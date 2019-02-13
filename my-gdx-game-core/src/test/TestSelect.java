package test;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSelect {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String path="assets/song";
		File songDir = new File(path);
		System.out.println(songDir.getAbsolutePath());
		assertTrue(songDir.isDirectory());
		for(File f : songDir.listFiles()) {
			if(f.isDirectory()) {
			}
		}
	}

}
