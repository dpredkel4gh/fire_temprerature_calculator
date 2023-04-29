package by.pvt.predkel.utils.optional;

import java.io.File;

/**
 * Рекурсивное удаление всего в заданной папке
 */
public class DeleteFiles {
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }

        //  удаляем директорию или файл на самом нижнем уровне.
        return dir.delete();
    }
}
