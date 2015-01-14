import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * 
 * 功能： 1 、实现把指定文件夹下的所有文件压缩为指定文件夹下指定 zip 文件 2 、实现把指定文件夹下的 zip 文件解压到指定目录下
 * 
 * @author simon.jia
 * 
 */
public class ZipUtils {
	/**
	 * 
	 * 方法名：Zip 描述： 日期：2012-4-1 下午2:10:13
	 * 
	 * @param sourceDir
	 *            //指定要压缩的文件夹路径
	 * @param outZipFile
	 *            //指定压缩后文件夹输出路径
	 * @return void
	 */
	public static void Zip(String sourceDir, String zipFile) {
		//创建一个输出流
		OutputStream os = null;
		try {
			//打开一个写ZIP文件的输出流
			os = new FileOutputStream(zipFile);
			//接上一个缓冲流、不用频繁读取文件
			BufferedOutputStream bos = new BufferedOutputStream(os);
			//读取ZIP文件当然要用到ZIP的文件打印流
			ZipOutputStream zos = new ZipOutputStream(bos);
			//打开要压缩的文件目录
			File file = new File(sourceDir);
			//基本路径
			String basePath = null;
			//如果有子目录就获得基本路径没有就获得上一节点路径
			if (file.isDirectory()) {
				basePath = file.getPath();
			} else {
				basePath = file.getParent();
			}
			//调用创建ZIP文件方法
			createZip(file, basePath, zos);
			//关掉当前ZIP写入流
			zos.closeEntry();
			//关掉ZIP流和过滤流
			zos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * 方法名：createZip 描述： 作者： 日期：2012-4-1 下午2:14:30
	 * 
	 * @param @param source
	 * @param @param basePath
	 * @param @param zos
	 * @return void
	 */
	private static void createZip(File source, String basePath,
			ZipOutputStream zos) {

		// 创建文件对象用于装载要压缩文件
		File[] files = new File[0];

		String pathName;

		int length = 0;
		// 检测是否有子目录
		if (source.isDirectory()) {
			// 获取目录下所有文档
			files = source.listFiles();
		} else {
			files = new File[1];
			files[0] = source;
		}
		byte[] buf = new byte[1024];
		try {
			for (File file : files) {
				if (file.isDirectory()) {
					// 获得文件路径+“/”表示还有子目录
					pathName = file.getPath().substring(basePath.length() + 1)
							+ "/";
					// 创建一个Zip文件目录进行传递给输出流
					zos.putNextEntry(new ZipEntry(pathName));
					// 递归压缩到没有子目录
					createZip(file, basePath, zos);
				} else {

					pathName = file.getPath().substring(basePath.length() + 1);
					// 打开文件输入通道
					InputStream is = new FileInputStream(file);
					// 使用缓冲流对接压缩流
					BufferedInputStream bis = new BufferedInputStream(is);
					// 创建压缩目录
					zos.putNextEntry(new ZipEntry(pathName));
					// 循环写入压缩流
					while ((length = bis.read(buf)) > 0) {
						zos.write(buf, 0, length);
					}
					// 关闭文件流
					is.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * 方法名：unZip 描述：不能解压rar 日期：2012-4-1 下午5:33:19
	 * 
	 * @param @param zipFile
	 * @param @param descDir
	 * @return void
	 */
	private static void unZip(String zipfile, String descDir) {
		// 验证目录正确性
		descDir = descDir.endsWith("//") ? descDir : descDir + "//";
		byte b[] = new byte[1024];
		int length;
		ZipFile zipFile;

		try {
			// 打开ZIP压缩文件
			zipFile = new ZipFile(new File(zipfile));
			// 返回文件目录枚举
			Enumeration enumeration = zipFile.entries();
			// 创建Zip目录
			ZipEntry zipEntry = null;
			// 遍历目录枚举
			while (enumeration.hasMoreElements()) {
				// 获得压缩目录
				zipEntry = (ZipEntry) enumeration.nextElement();
				// 创建压缩目录文件
				File loadFile = new File(descDir + zipEntry.getName());

				if (zipEntry.isDirectory()) {
					loadFile.mkdirs();
				} else {

					if (!loadFile.getParentFile().exists()) {
						loadFile.getParentFile().mkdirs();
					}
					OutputStream os = new FileOutputStream(loadFile);
					InputStream zis = zipFile.getInputStream(zipEntry);
					while ((length = zis.read(b)) > 0) {
						os.write(b, 0, length);
					}
					os.close();
				}
			}
			System.out.println(" 文件解压成功 ");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Zip("D://ziptest","D://ziptest.zip");
		//unZip("D://ziptest.zip","D://ziptest");
	}
}
