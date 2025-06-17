package com.simplecity.amp_library.utils;

import android.os.Environment;
import android.support.annotation.NonNull;
import com.simplecity.amp_library.ShuttleApplication;
import io.reactivex.Completable;
import java.io.File;

public class LegacyUtils {

    private LegacyUtils() {

    }

    @NonNull
    public static Completable deleteOldResources(ShuttleApplication application) {
        return Completable.fromAction(() -> {
            //Delete albumthumbs/artists directory
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                File file = new File(Environment.getExternalStorageDirectory() + "/albumthumbs/artists/");
                if (file.exists() && file.isDirectory()) {
                    File[] files = file.listFiles();
                    if (files != null) {
                        for (File child : files) {
                            boolean deleted = child.delete();
                            if (deleted) {
                                System.out.println("Le fichier/enfant a été supprimé avec succès.");
                            } else {
                                System.out.println("Échec de la suppression du fichier/enfant.");
                            }
                        }
                    }
                    if (file.delete()) {
                        System.out.println("Fichier supprimé avec succès.");
                    } else {
                        System.out.println("Échec de la suppression du fichier.");
                    }
                }
            }

            //Delete old http cache
            File oldHttpCache = application.getDiskCacheDir("http");
            if (oldHttpCache != null && oldHttpCache.exists()) {
                if (oldHttpCache.delete()) {
                    System.out.println("Cache supprimé avec succès.");
                } else {
                    System.out.println("Échec de la suppression du cache.");
                }
            }

            //Delete old thumbs cache
            File oldThumbsCache = application.getDiskCacheDir("thumbs");
            if (oldThumbsCache != null && oldThumbsCache.exists()) {
                if (oldThumbsCache.delete()) {
                    System.out.println("Cache supprimé avec succès.");
                } else {
                    System.out.println("Échec de la suppression du cache.");
                }
            }
        });
    }
}
