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
 * ���ܣ� 1 ��ʵ�ְ�ָ���ļ����µ������ļ�ѹ��Ϊָ���ļ�����ָ�� zip �ļ� 2 ��ʵ�ְ�ָ���ļ����µ� zip �ļ���ѹ��ָ��Ŀ¼��
 * 
 * @author simon.jia
 * 
 */
public class ZipUtils {
	/**
	 * 
	 * ��������Zip ������ ���ڣ�2012-4-1 ����2:10:13
	 * 
	 * @param sourceDir
	 *            //ָ��Ҫѹ�����ļ���·��
	 * @param outZipFile
	 *            //ָ��ѹ�����ļ������·��
	 * @return void
	 */
	public static void Zip(String sourceDir, String zipFile) {
		//����һ�������
		OutputStream os = null;
		try {
			//��һ��дZIP�ļ��������
			os = new FileOutputStream(zipFile);
			//����һ��������������Ƶ����ȡ�ļ�
			BufferedOutputStream bos = new BufferedOutputStream(os);
			//��ȡZIP�ļ���ȻҪ�õ�ZIP���ļ���ӡ��
			ZipOutputStream zos = new ZipOutputStream(bos);
			//��Ҫѹ�����ļ�Ŀ¼
			File file = new File(sourceDir);
			//����·��
			String basePath = null;
			//�������Ŀ¼�ͻ�û���·��û�оͻ����һ�ڵ�·��
			if (file.isDirectory()) {
				basePath = file.getPath();
			} else {
				basePath = file.getParent();
			}
			//���ô���ZIP�ļ�����
			createZip(file, basePath, zos);
			//�ص���ǰZIPд����
			zos.closeEntry();
			//�ص�ZIP���͹�����
			zos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * ��������createZip ������ ���ߣ� ���ڣ�2012-4-1 ����2:14:30
	 * 
	 * @param @param source
	 * @param @param basePath
	 * @param @param zos
	 * @return void
	 */
	private static void createZip(File source, String basePath,
			ZipOutputStream zos) {

		// �����ļ���������װ��Ҫѹ���ļ�
		File[] files = new File[0];

		String pathName;

		int length = 0;
		// ����Ƿ�����Ŀ¼
		if (source.isDirectory()) {
			// ��ȡĿ¼�������ĵ�
			files = source.listFiles();
		} else {
			files = new File[1];
			files[0] = source;
		}
		byte[] buf = new byte[1024];
		try {
			for (File file : files) {
				if (file.isDirectory()) {
					// ����ļ�·��+��/����ʾ������Ŀ¼
					pathName = file.getPath().substring(basePath.length() + 1)
							+ "/";
					// ����һ��Zip�ļ�Ŀ¼���д��ݸ������
					zos.putNextEntry(new ZipEntry(pathName));
					// �ݹ�ѹ����û����Ŀ¼
					createZip(file, basePath, zos);
				} else {

					pathName = file.getPath().substring(basePath.length() + 1);
					// ���ļ�����ͨ��
					InputStream is = new FileInputStream(file);
					// ʹ�û������Խ�ѹ����
					BufferedInputStream bis = new BufferedInputStream(is);
					// ����ѹ��Ŀ¼
					zos.putNextEntry(new ZipEntry(pathName));
					// ѭ��д��ѹ����
					while ((length = bis.read(buf)) > 0) {
						zos.write(buf, 0, length);
					}
					// �ر��ļ���
					is.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * ��������unZip ���������ܽ�ѹrar ���ڣ�2012-4-1 ����5:33:19
	 * 
	 * @param @param zipFile
	 * @param @param descDir
	 * @return void
	 */
	private static void unZip(String zipfile, String descDir) {
		// ��֤Ŀ¼��ȷ��
		descDir = descDir.endsWith("//") ? descDir : descDir + "//";
		byte b[] = new byte[1024];
		int length;
		ZipFile zipFile;

		try {
			// ��ZIPѹ���ļ�
			zipFile = new ZipFile(new File(zipfile));
			// �����ļ�Ŀ¼ö��
			Enumeration enumeration = zipFile.entries();
			// ����ZipĿ¼
			ZipEntry zipEntry = null;
			// ����Ŀ¼ö��
			while (enumeration.hasMoreElements()) {
				// ���ѹ��Ŀ¼
				zipEntry = (ZipEntry) enumeration.nextElement();
				// ����ѹ��Ŀ¼�ļ�
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
			System.out.println(" �ļ���ѹ�ɹ� ");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Zip("D://ziptest","D://ziptest.zip");
		//unZip("D://ziptest.zip","D://ziptest");
	}
}
