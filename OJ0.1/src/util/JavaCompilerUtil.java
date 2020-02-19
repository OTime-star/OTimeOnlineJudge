package util;

import java.io.File;
import java.util.Arrays;
 
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
 
public class JavaCompilerUtil {
    private static JavaCompiler javaCompiler;
 
    private JavaCompilerUtil() {
    };
 
    private static JavaCompiler getJavaCompiler() {
        if (javaCompiler == null) {
            synchronized (JavaCompilerUtil.class) {
                if (javaCompiler == null) {
                    javaCompiler = ToolProvider.getSystemJavaCompiler();
                }
            }
        }
 
        return javaCompiler;
    }
 
    public static boolean CompilerJavaFile(String sourceFileInputPath,
            String classFileOutputPath) {
        Iterable<String> options = Arrays.asList("-d", classFileOutputPath);
        StandardJavaFileManager fileManager = getJavaCompiler()
                .getStandardFileManager(null, null, null);
 
        Iterable<? extends JavaFileObject> compilationUnits = fileManager
                .getJavaFileObjectsFromFiles(Arrays.asList(new File(
                        sourceFileInputPath)));
 
        return getJavaCompiler().getTask(null, fileManager, null, options,
                null, compilationUnits).call();
    }
}

