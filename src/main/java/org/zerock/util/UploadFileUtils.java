package org.zerock.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class UploadFileUtils {

	private static final Logger logger = LoggerFactory.getLogger(UploadFileUtils.class);

	public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception {

		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() + "_" + originalName;
		String savedPath = calcPath(uploadPath);
		File target = new File(uploadPath + savedPath, savedName);

		// ���� ���� ���� �ϴ� �κ�
		FileCopyUtils.copy(fileData, target);
		// �������� Ȯ����
		String formatName = originalName.substring(originalName.lastIndexOf(".") + 1);
		String uploadedFileName = null;

		// Ȯ���ڰ� �̹����ΰ��, �ƴѰ��
		if (MediaUtils.getMediaType(formatName) != null) {
		//	uploadedFileName = makeThumbnail(uploadPath, savedPath, savedName);
		} else {
			uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
		}

		return uploadedFileName;
	}

	public static String getExtension(String fileName) {
		int dotPosition = fileName.lastIndexOf('.');

		if (-1 != dotPosition && fileName.length() - 1 > dotPosition) {
			return fileName.substring(dotPosition + 1);
		} else {
			return "";
		}
	}

	// ���ó���ϴ� ���ڿ��� ġȯ�뵵
	private static String makeIcon(String uploadPath, String path, String fileName) throws Exception {
		String iconName = uploadPath + path + File.separator + fileName;
		return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}

	// ����� ���ϸ��� ������ִ� �Լ�
	private static String calcPath(String uploadPath) {

		Calendar cal = Calendar.getInstance();

		String yearPath = File.separator + cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));

		makeDir(uploadPath, yearPath, monthPath, datePath);

		logger.info(datePath);

		return datePath;
	}

	// ���� �� �� �ִ� ���� �� ����� �Լ�
	private static void makeDir(String uploadPath, String... paths) {

		System.out.println(paths[paths.length - 1] + " : " + new File(paths[paths.length - 1]).exists());
		if (new File(paths[paths.length - 1]).exists()) {
			return;
		}

		for (String path : paths) {
			File dirPath = new File(uploadPath + path);

			if (!dirPath.exists()) {
				dirPath.mkdir();
			}
		}
	}

	// �̰� ���� �𸣰ٱ� ���ϰ�θ� ������ִ� �Լ� -> ��� ������?
	private static String makeFilePath(String uploadPath, String path, String fileName) throws IOException {
		String filePath = uploadPath + path + File.separator + fileName;
		return filePath.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}

	// ����� ������ִ� �Լ�
	// private static String makeThumbnail(String uploadPath, String path, String
	// fileName) throws Exception {
	//
	// BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path,
	// fileName));
	//
	// BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC,
	// Scalr.Mode.FIT_TO_HEIGHT, 100);
	//
	// String thumbnailName = uploadPath + path + File.separator + "s_" + fileName;
	//
	// File newFile = new File(thumbnailName);
	// String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
	//
	// ImageIO.write(destImg, formatName.toUpperCase(), newFile);
	//
	// return
	// thumbnailName.substring(uploadPath.length()).replace(File.separatorChar,
	// '/');
	// }
}
