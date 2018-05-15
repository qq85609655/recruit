package com.csot.recruit.service.attachment;

import java.util.List;

import com.csot.recruit.model.original.attachment.Attachment;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface AttachmentService {
    MiniRtn2Grid<Attachment> getGrid(MiniGridPageSort pageSort, String searchKey);

    Attachment getByPrimaryKey(String primaryKey);

    void create(Attachment attachment);

    void updateSelective(Attachment attachment);

    void remove(String primaryKey);

    List<Attachment> findAttachsByRelateId(String relateId);
}