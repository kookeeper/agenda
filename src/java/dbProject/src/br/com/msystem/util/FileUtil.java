package br.com.msystem.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileExistsException;
import org.apache.commons.io.FileUtils;

public class FileUtil {

	public static String efetivarArquivoTemporario(String fileName,
			Integer pessoaSq) throws IOException {

		String timestamp = String.valueOf(new Date().getTime());

		try {
			FileUtils.moveFile(new File(Constantes.TEMP_DIR, fileName), new File(new File(Constantes.TEMP_DIR, pessoaSq.toString()), timestamp));
		} catch (FileExistsException e) {
			timestamp = String.valueOf(Long.parseLong(timestamp) + 1);
			FileUtils.moveFile(new File(Constantes.TEMP_DIR, fileName), new File(new File(Constantes.TEMP_DIR, pessoaSq.toString()), timestamp));
		}
		
		return pessoaSq.toString() + "/" + timestamp;
	}

}
