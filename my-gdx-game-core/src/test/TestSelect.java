package test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileOutputStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kotcrab.vis.ui.widget.file.FileUtils;

public class TestSelect {
	static final private	String path="assets/song";
	static final private	String testSong = "Test Song";
	static final private	String [] stepFiles = {"Crazy_2.ksf", 
			"Crazy_1.ksf", "Hard_2.ksf", "Hard_1.ksf", "Easy_2.ksf", "Easy_1.ksf", "Double.ksf" };
	
	@BeforeClass
	public static void 처음_실행전_초기화() throws Exception {
		File songDir = new File(path);
		songDir.mkdirs();
		File beetoSongDir = new File(songDir.getAbsolutePath() + "/" + testSong);
		beetoSongDir.mkdirs();
		
		for(String sf : stepFiles) {
			final String fullPathStep = beetoSongDir + "/" + sf;
			File stepFile = new File(fullPathStep);
			if (!stepFile.exists())
		       new FileOutputStream(stepFile).close();
		}
	}

	@AfterClass
	public static void 마지막_종료후_제거() throws Exception {
		File songDir = new File(path);
		songDir.mkdirs();
		File beetoSongDir = new File(songDir.getAbsolutePath() + "/" + testSong);
		beetoSongDir.mkdirs();
		
	}

	
	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void test() {
		File songDir = new File(path);
		System.out.println(songDir.getAbsolutePath());
		assertTrue(songDir.isDirectory());
		for(File f : songDir.listFiles()) {
			if(f.isDirectory()) {				
			}
		}
	}

}
