package com.csot.recruit.service.campus;

import java.util.List;


import com.csot.recruit.model.original.campus.CampusAddressbook;
import com.csot.recruit.model.original.campus.CampusPost;
import com.csot.recruit.model.original.campus.CampusSite;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.springframework.web.multipart.MultipartFile;

public interface CampusAddressbookService {
    MiniRtn2Grid<CampusAddressbook> getGrid(MiniGridPageSort pageSort, String searchKey);

    CampusAddressbook getByPrimaryKey(String primaryKey);

    void create(CampusAddressbook campusAddressbook);

    void updateSelective(CampusAddressbook campusAddressbook);

    void remove(String primaryKey);

    String importAddressbook(MultipartFile multipartFile, String basePath, String importer)
        throws Exception;

    /**
     * 根据姓名导出通讯录信息
     * @param realName
     * @param response
     * @param request
     * @return
     */
    List<CampusAddressbook> exportPartNoRealName(String realName);

    List<CampusSite> doGetSiteInfo(String siteId, String siteName);

    List<CampusPost> doGetPostInfo(String id, String postName);

}