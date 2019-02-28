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

		// 원본 파일 저장 하는 부분
		FileCopyUtils.copy(fileData, target);
		// 원본파일 확장자
		String formatName = originalName.substring(originalName.lastIndexOf(".") + 1);
		String uploadedFileName = null;

		// 확장자가 이미지인경우, 아닌경우
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

	// 경로처리하는 문자열의 치환용도
	private static String makeIcon(String uploadPath, String path, String fileName) throws Exception {
		String iconName = uploadPath + path + File.separator + fileName;
		return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}

	// 저장된 파일명을 계산해주는 함수
	private static String calcPath(String uploadPath) {

		Calendar cal = Calendar.getInstance();

		String yearPath = File.separator + cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));

		makeDir(uploadPath, yearPath, monthPath, datePath);

		logger.info(datePath);

		return datePath;
	}

	// 저장 할 수 있는 파일 을 만드는 함수
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

	// 이건 뭔지 모르겟군 파일경로를 만들어주는 함수 -> 디비에 들어갈꼰가?
	private static String makeFilePath(String uploadPath, String path, String fileName) throws IOException {
		String filePath = uploadPath + path + File.separator + fileName;
		return filePath.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}

	// 썸네일 만들어주는 함수
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
