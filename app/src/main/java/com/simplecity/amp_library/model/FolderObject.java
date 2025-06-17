package com.simplecity.amp_library.model;

import com.simplecity.amp_library.interfaces.FileType;
import java.util.Objects;

public class FolderObject extends BaseFileObject {

    public int fileCount;
    public int folderCount;

    public FolderObject() {
        this.fileType = FileType.FOLDER;
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

    @Override
    public String toString() {
        return "FolderObject{" +
                "fileCount=" + fileCount +
                ", folderCount=" + folderCount +
                "} " + super.toString();
    }
}
