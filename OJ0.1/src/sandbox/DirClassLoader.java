package sandbox;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DirClassLoader extends ClassLoader{
	private String rootDir;
	
	public DirClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] classData = getClassData(name);
		if(classData == null) {
			throw new ClassNotFoundException();
		}else {
			return defineClass(name, classData, 0, classData.length);
		}
	}
	
	private byte[] getClassData(String className) {
		
        InputStream in = null;
        ByteArrayOutputStream out = null;
        String path = rootDir + File.separatorChar +
                      className.replace('.',File.separatorChar)+".class";
        try {
            in=new FileInputStream(path);
            out=new ByteArrayOutputStream();
            byte[] buffer=new byte[2048];
            int len=0;
            while((len=in.read(buffer))!=-1){
                out.write(buffer,0,len);
            }
            return out.toByteArray();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
				in.close();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        }
        return null;
	}
	
}
