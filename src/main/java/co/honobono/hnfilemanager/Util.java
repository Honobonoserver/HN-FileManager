package co.honobono.hnfilemanager;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Util {

	public static void Download(File out, String file) throws IOException {
		InputStream in = new URL(file).openConnection().getInputStream();
		if (out.exists()) {
			File fout = new File(out, ".bak");
			if (fout.exists()) {
				fout.delete();
			}
			out.renameTo(fout);
			out.delete();
		}
		DataOutputStream dataOutStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(out)));
		byte[] b = new byte[4096];
		int readByte = 0;
		while (-1 != (readByte = in.read(b))) {
			dataOutStream.write(b, 0, readByte);
		}
		in.close();
		dataOutStream.close();
	}

}
