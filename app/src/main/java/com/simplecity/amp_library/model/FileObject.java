package com.simplecity.amp_library.model;

import android.content.Context;
import com.simplecity.amp_library.interfaces.FileType;
import com.simplecity.amp_library.utils.FileHelper;
import com.simplecity.amp_library.utils.StringUtils;
import java.util.Objects;

public class FileObject extends BaseFileObject {

    public String extension;

    public TagInfo tagInfo;

    private long duration = 0;

    public FileObject() {
        this.fileType = FileType.FILE;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        FolderObject that = (FolderObject) obj;

        return fileCount == that.fileCount &&
               folderCount == that.folderCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fileCount, folderCount);
    }

    public String getTimeString(Context context) {
        if (duration == 0) {
            duration = FileHelper.getDuration(context, this);
        }
        return StringUtils.makeTimeString(context, duration / 1000);
    }

    @Override
    public String toString() {
        return "FileObject{" +
                "extension='" + extension + '\'' +
                ", size='" + size + '\'' +
                "} " + super.toString();
    }
}
