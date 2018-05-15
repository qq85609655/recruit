package com.csot.action;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.pdfbox.util.PDFMergerUtility;

import com.csot.base.jdbc.DataRow;
import com.csot.base.util.DateHelper;
import com.csot.base.util.FileHelper;
import com.csot.base.util.ListHelper;
import com.csot.base.util.MathHelper;
import com.csot.base.util.ResponseHelper;
import com.csot.base.util.ScriptHelper;
import com.csot.base.util.StringHelper;
import com.csot.config.Configuration;
import com.csot.config.SysConfig;
import com.csot.domain.TActivity;
import com.csot.domain.TActivityRevUser;
import com.csot.domain.TActivitySubject;
import com.csot.domain.TActivityUser;
import com.csot.domain.TActivityVolume;
import com.csot.domain.TEnumValue;
import com.csot.domain.TSingleReport;
import com.csot.domain.TSubjectAvg;
import com.csot.domain.TSubjectAvgDetail;
import com.csot.domain.TTeamReport;
import com.csot.domain.TTeamReportDetail;
import com.csot.domain.TVolumeAnswer;
import com.csot.domain.TVolumeLevelAnswer;
import com.csot.form.AnswerForm;
import com.csot.form.DataBeanTemp;
import com.csot.form.DataStore;
import com.csot.form.PersonReport19;
import com.csot.form.PersonReport20;
import com.csot.form.SubjectMatrix;
import com.csot.report.BarChart;
import com.csot.report.BarChartNew;
import com.csot.report.BarLineChart;
import com.csot.report.BarLineChartChoose;
import com.csot.report.LineChart;
import com.csot.report.PdfUtils;
import com.csot.service.ActivityVolumeService;
import com.csot.service.AnswerService;
import com.csot.system.SysLibrary;

@SuppressWarnings("all")
public class PdfAction extends BaseAction {

    @Resource
    ActivityVolumeService activityVolumeService;

    @Resource
    AnswerService answerService;

    private static Logger log = Logger.getLogger(PdfAction.class);

    public String doOpenTeamPdf() {

        String result = "twelve";
        int id = this.getIntParameter("id");
        int activity_id = this.getIntParameter("activity_id");
        TActivity activity = (TActivity) activityVolumeService.getByHql(
                "from TActivity where id = ?", new Object[] { activity_id })
                .get(0);
        String unitid = this.getStrParameter("unit_id");
        int unit_id = 0;
        if (unitid.indexOf("18-") > 0) {
            unit_id = 18;
        } else if (unitid.indexOf("19-") > 0) {
            unit_id = 19;
        } else {
            unit_id = Integer.parseInt(unitid);
        }
        TTeamReport ttr = (TTeamReport) activityVolumeService.getByHql(
                "from TTeamReport where id = ?", new Object[] { id }).get(0);
        String httpUrl = Configuration.getString("system.host");

        TTeamReportDetail ttrd = null;
        List<TActivitySubject> subjectList = activityVolumeService
                .getSubjectByActivityId(activity_id, "0");
        List<TActivitySubject> subList = new ArrayList();
        for (TActivitySubject tas : subjectList) {
            if (tas.getWorth() == null)
                subList.add(tas);
        }

        List<TActivityUser> uList = null;
        if ("ALL".equals(ttr.getUsers().toUpperCase())) {
            uList = activityVolumeService.getByHql(
                    "from TActivityUser where activityId = ?",
                    new Object[] { activity_id });
        } else {
            List<Integer> inList = new ArrayList();
            String[] arrs = ttr.getUsers().split("\\|");
            for (String s : arrs) {
                if (StringHelper.isNotBlank(s)) {
                    inList.add(Integer.parseInt(s));
                }
            }
            uList = activityVolumeService.queryListByIn(
                    "from TActivityUser where id in (:u)", "u", inList);
        }
        StringBuilder bd = new StringBuilder();
        for (TActivityUser tau : uList) {
            bd.append(tau.getUserid() + ",");
        }
        String users = bd.toString();

        switch (unit_id) {
        case 12:
            this.setAttribute(
                    "usercount",
                    "ALL".equals(ttr.getUsers()) ? activityVolumeService
                            .getByHql(
                                    "from TActivityUser where activityId = ?",
                                    new Object[] { activity_id }).size() : ttr
                            .getUsers().split("\\|").length);
            this.setAttribute("report_date",
                    DateHelper.formatDate(new Date(), "yyyy-MM-dd"));
            this.setAttribute("url", httpUrl);
            this.setAttribute("activityname", activity.getName());
            break;
        case 13:
        case 14:
            this.setAttribute(
                    "usercount",
                    "ALL".equals(ttr.getUsers()) ? activityVolumeService
                            .getByHql(
                                    "from TActivityUser where activityId = ?",
                                    new Object[] { activity_id }).size() : ttr
                            .getUsers().split("\\|").length);
            this.setAttribute(
                    "refusercount",
                    activityVolumeService.getByHql(
                            "from TActivityRevUser where activityId = ?",
                            new Object[] { activity_id }).size());
            this.setAttribute(
                    "finishcount",
                    activityVolumeService
                            .getByHql(
                                    "from TActivityRevUser where activityId = ? and status = 2",
                                    new Object[] { activity_id }).size());
            this.setAttribute(
                    "yxcount",
                    activityVolumeService
                            .querySqlMap(
                                    "select id from t_activity_rev_user where activity_id = ? and status = 2 and ( effect <> '0' or effect is null )",
                                    new Object[] { activity_id }).size());
            result = "thirteen";
            this.setAttribute("sList", subList);
            break;
        case 15:
        case 16:
            ttrd = (TTeamReportDetail) activityVolumeService.getByHql(
                    "from TTeamReportDetail where reportId = ? and unitId = ?",
                    new Object[] { id, unit_id }).get(0);
            this.setAttribute("path15", httpUrl + "/hrod/report/" + activity_id
                    + "/02/" + ttr.getId() + "/15.png");
            this.setAttribute("content15", ttrd.getContent());
            result = "fifteen";
            // break;
            ttrd = (TTeamReportDetail) activityVolumeService.getByHql(
                    "from TTeamReportDetail where reportId = ? and unitId = ?",
                    new Object[] { id, unit_id }).get(0);
            this.setAttribute("path16", httpUrl + "/hrod/report/" + activity_id
                    + "/02/" + ttr.getId() + "/16.png");
            this.setAttribute("content16", ttrd.getContent());
            // result = "sixteen";
            break;
        case 17:
            ttrd = (TTeamReportDetail) activityVolumeService.getByHql(
                    "from TTeamReportDetail where reportId = ? and unitId = ?",
                    new Object[] { id, unit_id }).get(0);
            this.setAttribute("path17", httpUrl + "/hrod/report/" + activity_id
                    + "/02/" + ttr.getId() + "/17.png");
            this.setAttribute("content17", ttrd.getContent());
            result = "seventeen";
            break;
        case 18:

            ttrd = (TTeamReportDetail) activityVolumeService.getByHql(
                    "from TTeamReportDetail where reportId = ? and unitId = ?",
                    new Object[] { id, unit_id }).get(0);
            this.setAttribute("subList", subList);
            /*
             * this.setAttribute("subList", subList); List<Map<Integer,
             * List<Double>>> mList18temp = new ArrayList(); List<AnswerForm>
             * list18 = new ArrayList(); for (TActivitySubject tas : subList) {
             * List<Double> iList = new ArrayList(); Map<Integer, List<Double>>
             * map = new HashMap(); for (TActivityUser tau : uList) {
             * List<DataRow> drList = answerService.getSubjectAvg( tas.getId(),
             * activity_id, tau.getId()); if (ListHelper.IsNotEmpty(drList)) {
             * iList.add(drList.get(0).getDouble("number")); AnswerForm af = new
             * AnswerForm(); af.setUserid(tau.getId());
             * af.setSubject_id(tas.getId());
             * af.setNumber(drList.get(0).getDouble("number")); list18.add(af);
             * }
             * 
             * } map.put(tas.getId(), iList); mList18temp.add(map); } for
             * (TActivitySubject tas : subList) { for (TActivityUser tau :
             * uList) { for (AnswerForm af : list18) { if (af.getSubject_id() ==
             * tas.getId() && af.getUserid() == tau.getId()) {
             * af.setContent(answerService.getFlag( af.getSubject_id(),
             * af.getNumber(), mList18temp)); } } } }
             */
            Map map18 = (Map) DataStore.getMap().get(unitid);
            this.setAttribute("url", httpUrl);
            this.setAttribute("list18", map18.get("list18"));
            this.setAttribute("uList", map18.get("list"));
            this.setAttribute("content18", ttrd.getContent());
            if (map18.containsKey("jixu")) {
                this.setAttribute("jixu", map18.get("jixu"));
            }
            result = "eighteen-1";
            break;
        case 19:
            ttrd = (TTeamReportDetail) activityVolumeService.getByHql(
                    "from TTeamReportDetail where reportId = ? and unitId = ?",
                    new Object[] { id, unit_id }).get(0);
            /*
             * List<PersonReport19> list19 =
             * answerService.getPersonReport19(uList); double temp19 = 0d; for
             * (PersonReport19 t19 : list19) { for (TActivitySubject tas :
             * subList) { if (tas.getWorth() == null) { List<DataRow> drList =
             * answerService.getSubjectAvg(tas.getId(), activity_id,
             * t19.getUserid());
             * 
             * if (ListHelper.IsNotEmpty(drList)) { temp19 +=
             * drList.get(0).getDouble("number"); } } }
             * t19.setDefen(MathHelper.getFloat(temp19, 2)); temp19 = 0d; }
             * Collections.sort(list19); for (int i = 0; i < list19.size(); i++)
             * { list19.get(i).setNumber(list19.size() - i); if ((i + 1.0) /
             * list19.size() > 0.7) { list19.get(i).setPaiming("up"); } else if
             * ((i + 1.0) / list19.size() < 0.2) {
             * list19.get(i).setPaiming("down"); } else {
             * list19.get(i).setPaiming("middle"); } }
             * Collections.reverse(list19); this.setAttribute("list19", list19);
             * this.setAttribute("content19", ttrd.getContent());
             */
            Map map19 = (Map) DataStore.getMap().get(unitid);
            this.setAttribute("list19", map19.get("list"));
            if (map19.containsKey("jixu")) {
                this.setAttribute("jixu", "Y");
            }
            result = "nineteen-1";
            break;
        case 20:
            ttrd = (TTeamReportDetail) activityVolumeService.getByHql(
                    "from TTeamReportDetail where reportId = ? and unitId = ?",
                    new Object[] { id, unit_id }).get(0);
            List<PersonReport20> list20_1 = new ArrayList();
            List<PersonReport20> list20_2 = new ArrayList();
            List<PersonReport20> list20_3 = new ArrayList();

            List<PersonReport20> all_list = answerService.getResult20(uList);
            double temp20 = 0d;
            for (PersonReport20 all : all_list) {
                for (TActivitySubject tas : subList) {
                    List<DataRow> drList = answerService.getSubjectAvg(
                            tas.getId(), activity_id, all.getUserid());
                    if (ListHelper.IsNotEmpty(drList)) {
                        temp20 += drList.get(0).getDouble("number");
                    }
                }
                all.setZhibiaodefen(temp20);
                temp20 = 0d;
            }
            Collections.sort(all_list);
            for (int i = 0; i < all_list.size(); i++) {
                all_list.get(i).setNumber(i + 1);
                if ((i + 1.0) / all_list.size() > 0.8) {
                    all_list.get(i).setPaiming("up");
                } else if ((i + 1.0) / all_list.size() < 0.2) {
                    all_list.get(i).setPaiming("down");
                } else {
                    all_list.get(i).setPaiming("middle");
                }
            }
            Iterator<PersonReport20> iter = all_list.iterator();
            while (iter.hasNext()) {
                PersonReport20 pr20 = iter.next();
                if (pr20.getDefen() >= 4.0) {
                    list20_1.add(pr20);
                    iter.remove();
                    continue;
                }
                if (pr20.getDefen() <= 3.20) {
                    list20_3.add(pr20);
                    iter.remove();
                }
            }
            list20_2.addAll(all_list);
            Collections.reverse(list20_1);
            Collections.reverse(list20_2);
            Collections.reverse(list20_3);
            this.setAttribute("list20_1", list20_1);
            this.setAttribute("list20_2", list20_2);
            this.setAttribute("list20_3", list20_3);
            this.setAttribute("content20", ttrd.getContent());
            result = "twenty";
            break;
        case 23:
            List<String> listys = new ArrayList<String>();
            List<String> listjq = new ArrayList<String>();
            ttrd = (TTeamReportDetail) activityVolumeService.getByHql(
                    "from TTeamReportDetail where reportId = ? and unitId = ?",
                    new Object[] { id, unit_id }).get(0);
            if (ttrd != null && StringHelper.isNotEmpty(ttrd.getContent())) {
                JSONObject json_content = JSONObject.fromObject(ttrd
                        .getContent());
                String ys = json_content.getString("ys");
                String jq = json_content.getString("jq");
                String[] arry_ys = ys.split("\\r\\n");
                String[] arry_jq = jq.split("\\r\\n");
                for (int i = 0; i < arry_ys.length; i++) {
                    listys.add(arry_ys[i]);
                }
                for (int j = 0; j < arry_jq.length; j++) {
                    listjq.add(arry_jq[j]);
                }
            }
            this.setAttribute("listys", listys);
            this.setAttribute("listjq", listjq);
            result = "twenty-three";
            this.setAttribute("end", "Y");
            break;
        default:
            break;
        }

        return result;
    }

    public String doOpenPdf() {
        String result = "one";
        int user_id = this.getIntParameter("user_id");
        int activity_id = this.getIntParameter("activity_id");
        String unitid = this.getStrParameter("unit_id");
        String first = "N";
        int unit_id = 0;
        if (unitid.indexOf("-") > 0) {
            unit_id = 10;
            if (unitid.indexOf("-0") > 0) {
                first = "Y";
            }
        } else
            unit_id = Integer.parseInt(unitid);

        String httpUrl = Configuration.getString("system.host");

        TActivityUser tau = (TActivityUser) activityVolumeService.getByHql(
                "from TActivityUser where id = ?", new Object[] { user_id })
                .get(0);
        TActivityVolume tav = (TActivityVolume) activityVolumeService.getByHql(
                "from TActivityVolume where activityId = ?",
                new Object[] { activity_id }).get(0);
        int volume_id = tav.getId();
        List<TActivitySubject> subList = activityVolumeService
                .getByHql(
                        "from TActivitySubject where volumeID = ? and subType = 0 and worth is null",
                        new Object[] { tav.getId() });
        String path = Configuration.getString("system.filePath") + "report\\"
                + activity_id + "\\01\\" + user_id;
        Map endMap = (Map) activityVolumeService
                .querySqlMap(
                        "SELECT MAX(UNIT_ID) UNIT_ID FROM T_SINGLE_REPORT WHERE ACTIVITY_ID = ? AND USER_ID = ?",
                        new Object[] { activity_id, user_id }).get(0);
        int end_id = Integer.parseInt(endMap.get("UNIT_ID").toString());

        switch (unit_id) {
        case 1:
            this.setAttribute("username", tau.getUserName());
            this.setAttribute("report_date",
                    DateHelper.formatDate(new Date(), "yyyy-MM-dd"));
            this.setAttribute("url1", httpUrl
                    + "/hrod/images/report/baobiao1.png");
            this.setAttribute("page", "1");

            break;
        case 2:
            this.setAttribute("page", "2");
            this.setAttribute("username", tau.getUserName());
            List<TActivityRevUser> revList = activityVolumeService.getByHql(
                    "from TActivityRevUser where activityId = ? and toUid = ?",
                    new Object[] { activity_id, user_id + "" });
            int finish_count = 0;
            int valid_count = 0;
            for (TActivityRevUser taru : revList) {
                if ("0".equals(taru.getEffect())) {
                    finish_count++;
                } else {
                    if (2 == taru.getStatus()) {
                        finish_count++;
                        if (!"0".equals(taru.getEffect()))
                            valid_count++;
                    }
                }
            }
            this.setAttribute("user_count", revList.size());
            this.setAttribute("finish_count", finish_count);
            this.setAttribute("valid_count", valid_count);
            this.setAttribute("sList", subList);
            result = "two";
            break;
        case 4:
            TSingleReport tsr4 = (TSingleReport) activityVolumeService
                    .getByHql(
                            "from TSingleReport where activityId = ? and user_id = ? and unitId = ?",
                            new Object[] { activity_id, user_id, 4 }).get(0);
            this.setAttribute("path4", httpUrl + "/hrod/report/" + activity_id
                    + "/01/" + user_id + "/4.png");
            this.setAttribute("content4", tsr4.getContent());
            if (4 == end_id) {
                this.setAttribute("end", "Y");
            }
            this.setAttribute("page", "3");
            result = "four";
            // break;
        case 5:
            TSingleReport tsr5 = (TSingleReport) activityVolumeService
                    .getByHql(
                            "from TSingleReport where activityId = ? and user_id = ? and unitId = ?",
                            new Object[] { activity_id, user_id, 5 }).get(0);
            this.setAttribute("path5", httpUrl + "/hrod/report/" + activity_id
                    + "/01/" + user_id + "/5.png");
            this.setAttribute("content5", tsr5.getContent());
            if (5 == end_id) {
                this.setAttribute("end", "Y");
            }
            this.setAttribute("page", "4");
            result = "four";
            break;
        case 6:
            TSingleReport tsr6 = (TSingleReport) activityVolumeService
                    .getByHql(
                            "from TSingleReport where activityId = ? and user_id = ? and unitId = ?",
                            new Object[] { activity_id, user_id, 6 }).get(0);
            this.setAttribute("path6", httpUrl + "/hrod/report/" + activity_id
                    + "/01/" + user_id + "/6.png");
            this.setAttribute("content6", tsr6.getContent());
            if (6 == end_id) {
                this.setAttribute("end", "Y");
            }
            this.setAttribute("page", "6");
            result = "six";
            // break;
        case 7:
            TSingleReport tsr7 = (TSingleReport) activityVolumeService
                    .getByHql(
                            "from TSingleReport where activityId = ? and user_id = ? and unitId = ?",
                            new Object[] { activity_id, user_id, 7 }).get(0);
            this.setAttribute("path7", httpUrl + "/hrod/report/" + activity_id
                    + "/01/" + user_id + "/7.png");
            this.setAttribute("content7", tsr7.getContent());
            if (7 == end_id) {
                this.setAttribute("end", "Y");
            }
            this.setAttribute("page", "7");
            result = "six";
            break;
        case 8:
            TSingleReport tsr8 = (TSingleReport) activityVolumeService
                    .getByHql(
                            "from TSingleReport where activityId = ? and user_id = ? and unitId = ?",
                            new Object[] { activity_id, user_id, 8 }).get(0);
            this.setAttribute("path8", httpUrl + "/hrod/report/" + activity_id
                    + "/01/" + user_id + "/8.png");
            this.setAttribute("content8", tsr8.getContent());
            if (8 == end_id) {
                this.setAttribute("end", "Y");
            }
            this.setAttribute("page", "8");
            result = "six";
            break;
        case 9:
            TSingleReport tsr94 = (TSingleReport) activityVolumeService
                    .getByHql(
                            "from TSingleReport where activityId = ? and user_id = ? and unitId = ?",
                            new Object[] { activity_id, user_id, 4 }).get(0);
            if (tsr94.getReportPath() == null
                    || "".equals(tsr94.getReportPath())) {
                break;
            }
            String subjectids = tsr94.getReportPath();
            String[] ids = subjectids.split("@@");
            ids[0] = activityVolumeService.getSubject(Integer.parseInt(ids[0]))
                    .getSubjectId() + "";
            ids[1] = activityVolumeService.getSubject(Integer.parseInt(ids[1]))
                    .getSubjectId() + "";
            if ("".equals(ids[0]) || "".equals(ids[1]))
                break;

            String sql9 = "SELECT DISTINCT CONTENT,ITEM_NAME,P.NAME,ITEM_VALUE FROM T_SUGGEST M,T_ENUM_VALUE N,T_SUBJECT P "
                    + "WHERE M.TYPE = N.ITEM_VALUE AND P.ID = M.SUBJECT_ID AND "
                    + "ENUM_TYPE = 'DEVELOP_TYPE' AND M.SUBJECT_ID = ? ORDER BY ITEM_VALUE";

            String sql_9 = "SELECT DISTINCT ITEM_NAME,ITEM_VALUE FROM T_SUGGEST M,T_ENUM_VALUE N,T_SUBJECT P "
                    + "WHERE M.TYPE = N.ITEM_VALUE AND P.ID = M.SUBJECT_ID AND "
                    + "ENUM_TYPE = 'DEVELOP_TYPE' AND M.SUBJECT_ID = ? ORDER BY ITEM_VALUE";

            List<Map> tempName = activityVolumeService.querySqlMap(sql_9,
                    new Object[] { Integer.parseInt(ids[0]) });
            List<Map> tempName1 = activityVolumeService.querySqlMap(sql_9,
                    new Object[] { Integer.parseInt(ids[1]) });

            List<Map> list_91 = activityVolumeService.querySqlMap(sql9,
                    new Object[] { Integer.parseInt(ids[0]) });
            List<DataBeanTemp> list91 = new ArrayList();
            List<DataBeanTemp> list92 = new ArrayList();
            String subject1 = "";
            String subject2 = "";
            for (Map map : tempName) {
                DataBeanTemp dbt = new DataBeanTemp();
                dbt.setName(map.get("ITEM_NAME") + "");
                dbt.setMlist(new ArrayList<Map>());
                for (Map smap : list_91) {
                    subject1 = smap.get("NAME") + "";
                    if ((map.get("ITEM_NAME") + "").equals(smap
                            .get("ITEM_NAME") + "")) {
                        Map tMap = new HashMap();
                        tMap.put("NAME", smap.get("NAME"));
                        tMap.put("CONTENT", smap.get("CONTENT"));
                        dbt.getMlist().add(tMap);
                    }
                }
                list91.add(dbt);
            }
            List<Map> list_92 = activityVolumeService.querySqlMap(sql9,
                    new Object[] { Integer.parseInt(ids[1]) });
            for (Map map : tempName1) {
                DataBeanTemp dbt = new DataBeanTemp();
                dbt.setName(map.get("ITEM_NAME") + "");
                dbt.setMlist(new ArrayList<Map>());
                for (Map smap : list_92) {
                    subject2 = smap.get("NAME") + "";
                    if ((map.get("ITEM_NAME") + "").equals(smap
                            .get("ITEM_NAME") + "")) {
                        Map tMap = new HashMap();
                        tMap.put("NAME", smap.get("NAME"));
                        tMap.put("CONTENT", smap.get("CONTENT"));
                        dbt.getMlist().add(tMap);
                    }
                }
                list92.add(dbt);
            }
            this.setAttribute("list91", list91);
            this.setAttribute("list92", list92);
            this.setAttribute("subject1", subject1);
            this.setAttribute("subject2", subject2);
            result = "nine";
            break;
        case 10:
            Object ob = DataStore.getMap();
            Map map = (Map) DataStore.getMap().get(unitid);
            if (map.containsKey("ys")) {
                List<SubjectMatrix> ysList = (List<SubjectMatrix>) map
                        .get("ys");
                Iterator<SubjectMatrix> iter = ysList.iterator();
                while (iter.hasNext()) {
                    if (ListHelper.IsNotEmpty(iter.next().getSlist())) {
                    } else
                        iter.remove();
                }
                if (map.containsKey("ysjixu")) {
                    this.setAttribute("ysjixu", "Y");
                }
                this.setAttribute("youshi", "Y");
                this.setAttribute("ysList", ysList);
            }
            if (map.containsKey("jq")) {
                List<SubjectMatrix> jqList = (List<SubjectMatrix>) map
                        .get("jq");
                Iterator<SubjectMatrix> iter = jqList.iterator();
                while (iter.hasNext()) {
                    if (ListHelper.IsNotEmpty(iter.next().getSlist())) {
                    } else
                        iter.remove();
                }
                if (map.containsKey("jqjixu")) {
                    this.setAttribute("jqjixu", "Y");
                }
                this.setAttribute("tisheng", "Y");
                this.setAttribute("jqList", jqList);
            }
            result = "Y".equals(first) ? "ten-1" : "ten-2";
            break;

        case 11:
            List<String> listys = new ArrayList<String>();
            List<String> listjq = new ArrayList<String>();
            TSingleReport tsr11 = (TSingleReport) activityVolumeService
                    .getByHql(
                            "from TSingleReport where activityId = ? and user_id = ? and unitId = ?",
                            new Object[] { activity_id, user_id, unit_id })
                    .get(0);
            if (tsr11 != null && tsr11.getContent() != null
                    && !"".equals(tsr11.getContent())) {
                JSONObject json_content = JSONObject.fromObject(tsr11
                        .getContent());
                String ys = json_content.getString("ys");
                String jq = json_content.getString("jq");
                String[] arry_ys = ys.split("\\r\\n");
                String[] arry_jq = jq.split("\\r\\n");
                for (int i = 0; i < arry_ys.length; i++) {
                    listys.add(arry_ys[i]);
                }
                for (int j = 0; j < arry_jq.length; j++) {
                    listjq.add(arry_jq[j]);
                }
            }
            this.setAttribute("listys", listys);
            this.setAttribute("listjq", listjq);
            result = "eleven";
            break;
        default:
            break;
        }

        return result;
    }

    public String doGenerateTeamReport() {
        String filepath = Configuration.getString("system.filePath");
        String urlpath = Configuration.getString("system.host");
        String teams = this.getStrParameter("ids");
        int activity_id = this.getIntParameter("activity_id");
        String deleteflag = this.getStrParameter("deleteFlag");
        String[] ids = teams.split(",");
        List<TActivitySubject> subjectList = activityVolumeService
                .getSubjectByActivityId(activity_id, "0");
        List<TActivitySubject> subList = new ArrayList();
        for (TActivitySubject tas : subjectList) {
            if (tas.getWorth() == null)
                subList.add(tas);
        }

        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == null || "".equals(ids[i]))
                continue;
            List<TTeamReportDetail> tList = activityVolumeService.getByHql(
                    "from TTeamReportDetail where reportId = ?",
                    new Object[] { Integer.parseInt(ids[i]) });
            if (tList == null || tList.size() == 0) {
                TTeamReport ttr = (TTeamReport) activityVolumeService.getByHql(
                        "from TTeamReport where id = ?",
                        new Object[] { Integer.parseInt(ids[i]) }).get(0);
                ttr.setEditTime(DateHelper.formatDate(new Date()));
                activityVolumeService.updateActivityVolumeObject(ttr);
                ResponseHelper.print(getResponse(),
                        "请先设置" + ttr.getReportname() + "的模板！");
                return null;
            }
        }

        for (int i = 0; i < ids.length; i++) {
            if ("Y".equals(deleteflag)) {
                File file = new File(Configuration.getString("system.filePath")
                        + "report\\" + activity_id + "\\02\\" + ids[i]);
                if (file.exists())
                    FileHelper.cleanDirectory(file);
            }
            if (ids[i] == null || "".equals(ids[i]))
                continue;

            TTeamReport ttr = (TTeamReport) activityVolumeService.getByHql(
                    "from TTeamReport where id = ?",
                    new Object[] { Integer.parseInt(ids[i]) }).get(0);
            List<TActivityUser> uList = null;
            if ("ALL".equals(ttr.getUsers().toUpperCase())) {
                uList = activityVolumeService.getByHql(
                        "from TActivityUser where activityId = ?",
                        new Object[] { activity_id });
            } else {
                List<Integer> inList = new ArrayList();
                String[] arrs = ttr.getUsers().split("\\|");
                for (String s : arrs) {
                    if (StringHelper.isNotBlank(s)) {
                        inList.add(Integer.parseInt(s));
                    }
                }
                uList = activityVolumeService.queryListByIn(
                        "from TActivityUser where id in (:u)", "u", inList);
            }

            this.doTeamPicture(Integer.parseInt(ids[i]));
            List<TTeamReportDetail> tList = activityVolumeService.getByHql(
                    "from TTeamReportDetail where reportId = ?",
                    new Object[] { Integer.parseInt(ids[i]) });
            List<String> pdflist = new ArrayList();
            Collections.sort(tList);
            for (TTeamReportDetail ttrd : tList) {
                if (ttrd.getUnitId() == 13 || ttrd.getUnitId() == 16)
                    continue;
                if (ttrd.getUnitId() == 18) {
                    List<Map<Integer, List<Double>>> mList18temp = new ArrayList();
                    List<AnswerForm> list18 = new ArrayList();
                    for (TActivitySubject tas : subList) {
                        List<Double> iList = new ArrayList();
                        Map<Integer, List<Double>> map = new HashMap();
                        for (TActivityUser tau : uList) {
                            List<DataRow> drList = answerService.getSubjectAvg(
                                    tas.getId(), activity_id, tau.getId());
                            if (ListHelper.IsNotEmpty(drList)) {
                                iList.add(drList.get(0).getDouble("number"));
                                AnswerForm af = new AnswerForm();
                                af.setUserid(tau.getId());
                                af.setSubject_id(tas.getId());
                                af.setNumber(drList.get(0).getDouble("number"));
                                list18.add(af);
                            }

                        }
                        map.put(tas.getId(), iList);
                        mList18temp.add(map);
                    }
                    for (TActivitySubject tas : subList) {
                        for (TActivityUser tau : uList) {
                            for (AnswerForm af : list18) {
                                if (af.getSubject_id() == tas.getId()
                                        && af.getUserid() == tau.getId()) {
                                    af.setContent(answerService.getFlag(
                                            af.getSubject_id(), af.getNumber(),
                                            mList18temp));
                                }
                            }
                        }
                    }

                    /*
                     * this.setAttribute("url", httpUrl);
                     * this.setAttribute("list18", list18);
                     * this.setAttribute("uList", uList);
                     * this.setAttribute("content18", ttrd.getContent()); result
                     * = "eighteen";
                     */
                    List<TActivityUser> uList18 = new ArrayList();
                    List<List<TActivityUser>> fyList18 = new ArrayList();
                    int ys18 = 0;
                    Map map18 = new HashMap();
                    map18.put("list18", list18);
                    map18.put("url", Configuration.getString("system.host"));
                    map18.put("jixu", "Y");
                    for (int i18 = 0; i18 < uList.size(); i18++) {
                        if (i18 % 28 == 0 && i18 > 0) {

                            String pdfpath = filepath + "report\\"
                                    + activity_id + "\\02\\"
                                    + ttrd.getReportId() + "\\"
                                    + ttrd.getUnitId() + "-" + ys18 + ".pdf";
                            String url_path = urlpath
                                    + "/hrod/pdf.action?function=OpenTeamPdf&id="
                                    + ttrd.getReportId() + "&activity_id="
                                    + activity_id + "&unit_id=" + ids[i] + "-"
                                    + 18 + "-" + ys18;
                            map18.put("list", uList18);
                            if (ys18 == 0) {
                                map18.remove("jixu");
                            } else {
                                map18.put("jixu", "Y");
                            }
                            DataStore.getMap().put(
                                    ids[i] + "-" + 18 + "-" + ys18, map18);
                            ys18++;

                            if (new File(pdfpath).exists()) {
                                pdflist.add(pdfpath);
                                continue;
                            }

                            PdfUtils.toPdf(pdfpath, url_path, 0);
                            pdflist.add(pdfpath);
                            uList18.clear();
                            uList18.add(uList.get(i18));
                            continue;
                        }
                        uList18.add(uList.get(i18));
                    }
                    if (ListHelper.IsNotEmpty(uList18)) {
                        if (ys18 == 0) {
                            map18.remove("jixu");
                        } else {
                            map18.put("jixu", "Y");
                        }
                        map18.put("list", uList18);
                        DataStore.getMap().put(ids[i] + "-" + 18 + "-" + ys18,
                                map18);

                        String pdfpath = filepath + "report\\" + activity_id
                                + "\\02\\" + ttrd.getReportId() + "\\"
                                + ttrd.getUnitId() + "-" + ys18 + ".pdf";
                        String url_path = urlpath
                                + "/hrod/pdf.action?function=OpenTeamPdf&id="
                                + ttrd.getReportId() + "&activity_id="
                                + activity_id + "&unit_id=" + ids[i] + "-" + 18
                                + "-" + ys18;

                        if (new File(pdfpath).exists()) {
                            pdflist.add(pdfpath);
                            continue;
                        }
                        PdfUtils.toPdf(pdfpath, url_path, 0);
                        pdflist.add(pdfpath);
                    }
                    continue;
                }
                if (ttrd.getUnitId() == 19) {

                    List<PersonReport19> list19 = answerService
                            .getPersonReport19(uList);
                    double temp19 = 0d;
                    for (PersonReport19 t19 : list19) {
                        for (TActivitySubject tas : subList) {
                            if (tas.getWorth() == null) {
                                List<DataRow> drList = answerService
                                        .getSubjectAvg(tas.getId(),
                                                activity_id, t19.getUserid());

                                if (ListHelper.IsNotEmpty(drList)) {
                                    temp19 += drList.get(0).getDouble("number");
                                }
                            }
                        }
                        t19.setDefen(MathHelper.getFloat(temp19, 2));
                        temp19 = 0d;
                    }
                    Collections.sort(list19);
                    for (int i19 = 0; i19 < list19.size(); i19++) {
                        list19.get(i19).setNumber(list19.size() - i19);
                        if ((i19 + 1.0) / list19.size() > 0.7) {
                            list19.get(i19).setPaiming("up");
                        } else if ((i19 + 1.0) / list19.size() < 0.3) {
                            list19.get(i19).setPaiming("down");
                        } else {
                            list19.get(i19).setPaiming("middle");
                        }
                    }
                    Collections.reverse(list19);
                    Map map19 = new HashMap();
                    map19.put("jixu", "Y");
                    List<PersonReport19> list_19 = new ArrayList();
                    int ys19 = 0;
                    for (int b = 0; b < list19.size(); b++) {
                        if (b % 18 == 0 && b != 0) {

                            map19.put("list", list_19);
                            if (ys19 == 0) {
                                map19.remove("jixu");
                            } else {
                                map19.put("jixu", "Y");
                            }

                            DataStore.getMap().put(
                                    ids[i] + "-" + 19 + "-" + ys19, map19);

                            String pdfpath = filepath + "report\\"
                                    + activity_id + "\\02\\"
                                    + ttrd.getReportId() + "\\"
                                    + ttrd.getUnitId() + "-" + ys19 + ".pdf";
                            String url_path = urlpath
                                    + "/hrod/pdf.action?function=OpenTeamPdf&id="
                                    + ttrd.getReportId() + "&activity_id="
                                    + activity_id + "&unit_id=" + ids[i] + "-"
                                    + 19 + "-" + ys19;
                            if (new File(pdfpath).exists()) {
                                pdflist.add(pdfpath);
                                continue;
                            }
                            PdfUtils.toPdf(pdfpath, url_path, 0);
                            pdflist.add(pdfpath);
                            list_19.clear();
                            list_19.add(list19.get(b));
                            ys19++;
                            continue;

                        }
                        list_19.add(list19.get(b));
                    }

                    if (ListHelper.IsNotEmpty(list_19)) {
                        map19.put("list", list_19);
                        if (ys19 == 0) {
                            map19.remove("jixu");
                        } else {
                            map19.put("jixu", "Y");
                        }
                        DataStore.getMap().put(ids[i] + "-" + 19 + "-" + ys19,
                                map19);

                        String pdfpath = filepath + "report\\" + activity_id
                                + "\\02\\" + ttrd.getReportId() + "\\"
                                + ttrd.getUnitId() + "-" + ys19 + ".pdf";
                        String url_path = urlpath
                                + "/hrod/pdf.action?function=OpenTeamPdf&id="
                                + ttrd.getReportId() + "&activity_id="
                                + activity_id + "&unit_id=" + ids[i] + "-" + 19
                                + "-" + ys19;
                        if (new File(pdfpath).exists()) {
                            pdflist.add(pdfpath);
                            continue;
                        }
                        PdfUtils.toPdf(pdfpath, url_path, 0);
                        pdflist.add(pdfpath);
                        list_19.clear();
                        continue;
                    }

                    continue;
                }
                String pdfpath = filepath + "report\\" + activity_id + "\\02\\"
                        + ttrd.getReportId() + "\\" + ttrd.getUnitId() + ".pdf";
                String url_path = urlpath
                        + "/hrod/pdf.action?function=OpenTeamPdf&id="
                        + ttrd.getReportId() + "&activity_id=" + activity_id
                        + "&unit_id=" + ttrd.getUnitId();
                if (new File(pdfpath).exists()) {
                    pdflist.add(pdfpath);
                    continue;
                }
                if (ttrd.getUnitId() == 12) {
                    PdfUtils.toPdf(pdfpath, url_path, 1);
                } else {
                    PdfUtils.toPdf(pdfpath, url_path, 0);
                }
                pdflist.add(pdfpath);
            }
            PDFMergerUtility mergePdf = new PDFMergerUtility();
            for (String spa : pdflist) {
                if (!new File(spa).exists())
                    continue;
                mergePdf.addSource(spa);
            }
            mergePdf.setDestinationFileName(filepath + "report\\" + activity_id
                    + "\\02\\" + ids[i] + "\\" + ids[i] + ".pdf");
            try {
                mergePdf.mergeDocuments();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        ResponseHelper.print(getResponse(), "SUC");
        return null;
    }

    private void doTeamPicture(int parseInt) {
        int id = parseInt;
        TTeamReport ttr = (TTeamReport) activityVolumeService.getByHql(
                "from TTeamReport where id = ?", new Object[] { id }).get(0);
        int activity_id = ttr.getActivityId();
        TActivity activity = (TActivity) activityVolumeService.getByHql(
                "from TActivity where id = ?", new Object[] { activity_id })
                .get(0);
        List<TActivitySubject> tasList = activityVolumeService
                .getSubjectByActivityId(ttr.getActivityId(), "0");
        int volume_id = tasList.get(0).getVolumeID();
        boolean activitytype = activityVolumeService.ifLevel(ttr
                .getActivityId()); // 真是关键行为，假是行为等级
        List<TTeamReportDetail> ttrdList = activityVolumeService.getByHql(
                "from TTeamReportDetail where reportId = ?",
                new Object[] { ttr.getId() });
        Collections.sort(ttrdList);
        List<TActivityUser> uList = null;
        if ("ALL".equals(ttr.getUsers().toUpperCase())) {
            uList = activityVolumeService.getByHql(
                    "from TActivityUser where activityId = ?",
                    new Object[] { activity_id });
        } else {
            List<Integer> inList = new ArrayList();
            String[] arrs = ttr.getUsers().split("\\|");
            for (String s : arrs) {
                if (StringHelper.isNotBlank(s)) {
                    inList.add(Integer.parseInt(s));
                }
            }
            uList = activityVolumeService.queryListByIn(
                    "from TActivityUser where id in (:u)", "u", inList);
        }
        StringBuilder bd = new StringBuilder();
        for (TActivityUser tau : uList) {
            bd.append(tau.getUserid() + ",");
        }
        String users = bd.toString();
        for (TTeamReportDetail ttrd : ttrdList) {
            switch (ttrd.getUnitId()) {
            case 12: // 封面，不理他
                break;
            case 13: // 前言，不管他
                break;
            case 14: // 指标说明，要
                break;
            case 15: // 总得分统计
                String path15 = Configuration.getString("system.filePath")
                        + "report\\" + activity_id + "\\02\\" + ttr.getId();
                File file15 = new File(path15);
                if (!file15.exists())
                    file15.mkdirs();
                else {
                    if (new File(path15 + "\\15.png").exists()) {
                        this.setAttribute("path15", "/hrod/report/"
                                + activity_id + "/02/" + ttr.getId()
                                + "/15.png");
                        this.setAttribute("content15", ttrd.getContent());
                        break;
                    }
                }
                List<DataRow> listdatarow15 = new ArrayList();
                for (TActivitySubject tas : tasList) {
                    if (tas.getWorth() == null) {
                        DataRow dr15 = answerService.getSubjectAvg(tas.getId(),
                                activity_id, users);
                        DataTeamSubject dts = new DataTeamSubject();
                        dts.setName(tas.getName());
                        dts.setNumber(dr15.getDouble("number"));
                        if (activitytype)
                            ;
                        else
                            dr15.put(
                                    "levelname",
                                    answerService.getSubjectDescription(
                                            tas.getId(),
                                            dr15.getDouble("number")));
                        listdatarow15.add(dr15);
                    }
                }
                Collections.sort(listdatarow15, new Comparator<DataRow>() {
                    public int compare(DataRow o1, DataRow o2) {
                        return o1.getDouble("number") > o2.getDouble("number") ? 1
                                : -1;
                    }
                });
                Collections.reverse(listdatarow15);
                if (activitytype)
                    BarLineChartChoose.newBaseImage(listdatarow15, path15
                            + "\\15.png");
                else
                    BarLineChart.newBaseImage(listdatarow15, path15
                            + "\\15.png");
                this.setAttribute("path15", "/hrod/report/" + activity_id
                        + "/02/" + ttr.getId() + "/15.png");
                String content15 = "被评价人在"
                        + listdatarow15.get(0).getString("name")
                        + "方面表现较好，在"
                        + listdatarow15.get(listdatarow15.size() - 1)
                                .getString("name") + "方面可能有待加强。";
                this.setAttribute("content15", content15);
                ttrd.setContent(content15);
                activityVolumeService.updateActivityVolumeObject(ttrd);
                break;
            case 16: // 群体水平对比分析
                String path16 = Configuration.getString("system.filePath")
                        + "report\\" + activity_id + "\\02\\" + ttr.getId();
                File file16 = new File(path16);
                if (!file16.exists())
                    file16.mkdirs();
                else {
                    if (new File(path16 + "\\16.png").exists()) {
                        break;
                    }
                }

                String avgsql = "SELECT AVGID,COUNT(*) COUNTID FROM "
                        + "( SELECT DISTINCT B.AVGID,A.NAME FROM T_ACTIVITY_SUBJECT A,"
                        + "T_SUBJECT_AVG_DETAIL B,T_SUBJECT_AVG C "
                        + "WHERE A.NAME = B.SUBJECT_NAME AND A.BEHAVIOR_TYPE = "
                        + "C.SUBJECTTYPE AND C.ID = B.AVGID AND B.AVGID = "
                        + "B.AVGID AND A.VOLUME_ID = ? AND B.SUBJECT_SCORE IS NOT NULL AND A.WORTH IS NULL ) "
                        + "GROUP BY AVGID HAVING COUNT(*) = ?";
                List<Map> avgList = activityVolumeService.querySqlMap(avgsql,
                        new Object[] { volume_id, tasList.size() });
                if (avgList == null || avgList.size() == 0) {
                    this.setAttribute("path16", "#");
                    this.setAttribute("avgid", "0");
                    this.setAttribute("pathid16", "#");
                } else {
                    int avgid = Integer.parseInt(avgList.get(0).get("AVGID")
                            .toString());
                    TSubjectAvg subjectavg = (TSubjectAvg) activityVolumeService
                            .getByHql("from TSubjectAvg where id = ?",
                                    new Object[] { avgid }).get(0);
                    this.setAttribute("avgid", avgid);
                    List<TSubjectAvgDetail> avgDetailList = activityVolumeService
                            .getByHql("from TSubjectAvgDetail where avgid = ?",
                                    new Object[] { avgid });
                    List<DataBean7> db16List = new ArrayList();
                    List<DataRow> lineList16 = new ArrayList();
                    for (TActivitySubject tas16 : tasList) {
                        if (tas16.getWorth() != null)
                            continue;
                        TSubjectAvgDetail tsad = (TSubjectAvgDetail) activityVolumeService
                                .getByHql(
                                        "from TSubjectAvgDetail where avgid = ? and subjectName = ?",
                                        new Object[] { avgid, tas16.getName() })
                                .get(0);
                        DataRow subjectList16Temp = answerService
                                .getSubjectAvg(tas16.getId(), activity_id,
                                        users);

                        DataBean7 db16 = new DataBean7();
                        db16.setD7(Double.parseDouble(tsad.getSubjectScore())
                                - subjectList16Temp.getDouble("number"));
                        db16.setSubjectid(tas16.getId());
                        db16.setName(tas16.getName());
                        db16List.add(db16);

                        DataRow dr1 = new DataRow();
                        DataRow dr2 = new DataRow();
                        dr1.set("name", tas16.getName());
                        dr1.set("user_type", subjectavg.getAvgname());
                        dr1.set("number",
                                Double.parseDouble(tsad.getSubjectScore()));
                        lineList16.add(dr1);
                        dr2.set("name", tas16.getName());
                        dr2.set("user_type", "被评价人得分");
                        dr2.set("number", subjectList16Temp.getDouble("number"));
                        lineList16.add(dr2);

                    }
                    LineChart.toLineChart(lineList16, path16 + "\\16.png");
                    Collections.sort(db16List);
                    if (ttrd == null || "".equals(ttrd.getContent())) {
                        String content16 = "被评价人在" + db16List.get(0).getName()
                                + "," + db16List.get(0).getName()
                                + "方面可能较群体平均水平更良好，在"
                                + db16List.get(db16List.size() - 1).getName()
                                + ","
                                + db16List.get(db16List.size() - 2).getName()
                                + "方面可能较群体平均水平偏弱";
                        ttrd.setContent(content16);
                        activityVolumeService.updateActivityVolumeObject(ttrd);
                    }
                }

                break;
            case 17:
                String path17 = Configuration.getString("system.filePath")
                        + "report\\" + activity_id + "\\02\\" + ttr.getId();
                File file17 = new File(path17);
                if (!file17.exists())
                    file17.mkdirs();
                else {
                    if (new File(path17 + "\\17.png").exists()) {
                        break;
                    }
                }

                List<TActivity> aList = activityVolumeService.getByHql(
                        "from TActivity", null);
                int activity_old_id = 0;
                TActivity tactivity = null;
                for (TActivity ta : aList) {
                    if (answerService.judgeActivityMatch(tasList.size(),
                            activity_id, ta.getId())) {
                        activity_old_id = ta.getId();
                        tactivity = ta;
                        break;
                    }
                }
                if (activity_old_id > 0) {
                    List<DataBean7> ckList17 = new ArrayList<DataBean7>();
                    List<DataRow> list17 = new ArrayList<DataRow>();
                    List<TActivitySubject> oldSubject = activityVolumeService
                            .getSubjectByActivityId(activity_id, "0");
                    for (TActivitySubject tas : tasList) {
                        if (tas.getWorth() != null)
                            continue;
                        for (TActivitySubject oldtas : oldSubject) {
                            if (tas.getName().equals(oldtas.getName())) {
                                DataRow dr1 = new DataRow();
                                DataRow dr2 = new DataRow();
                                DataRow nList8 = answerService.getSubjectAvg(
                                        tas.getId(), activity_id, users);

                                DataRow oList8 = answerService.getSubjectAvg(
                                        oldtas.getId(), activity_old_id, users);

                                DataRow ndr = nList8;
                                DataRow odr = oList8;
                                DataBean7 db8 = new DataBean7();
                                db8.setD7(ndr.getDouble("number")
                                        - ndr.getDouble("number"));
                                db8.setName(tas.getName());
                                db8.setSubjectid(tas.getId());
                                ckList17.add(db8);

                                dr1.set("name", tas.getName());
                                dr1.set("user_type", "被评价人得分");
                                dr1.set("number", ndr.getDouble("number"));
                                list17.add(dr1);
                                dr2.set("name", tas.getName());
                                dr2.set("user_type", tactivity.getName());
                                dr2.set("number", ndr.getDouble("number"));
                                list17.add(dr2);
                            }
                        }
                    }

                    Collections.sort(ckList17);
                    LineChart.toLineChart(list17, path17 + "\\17.png");

                    if (ttrd == null || "".equals(ttrd.getContent())) {
                        String content17 = "被评价人在" + ckList17.get(0).getName()
                                + "," + ckList17.get(0).getName() + "方面可能有提升。";
                        ttrd.setContent(content17);
                        activityVolumeService.updateActivityVolumeObject(ttrd);
                    }
                }
                break;
            case 18:
                break;
            case 19:
                break;
            case 20:
                break;
            case 23:
                break;
            default:
                break;
            }
        }
    }

    public String doGenerateReport() {
        String filepath = Configuration.getString("system.filePath");
        String urlpath = Configuration.getString("system.host");
        String users = this.getStrParameter("ids");
        int activity_id = this.getIntParameter("activity_id");
        String deleteflag = this.getStrParameter("deleteFlag");
        String[] ids = users.split(",");

        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == null || "".equals(ids[i]))
                continue;
            List<TSingleReport> tList = activityVolumeService.getByHql(
                    "from TSingleReport where activityId = ? and userId = ?",
                    new Object[] { activity_id, Integer.parseInt(ids[i]) }); // 获取个人报告
            if (tList == null || tList.size() == 0) {
                TActivityUser tau = (TActivityUser) activityVolumeService
                        .getByHql("from TActivityUser where id = ?",
                                new Object[] { Integer.parseInt(ids[i]) }).get(
                                0);
                ResponseHelper.print(getResponse(), "请先设置" + tau.getUserName()
                        + "的模板！");
                return null;
            }
        }
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == null || "".equals(ids[i]))
                continue;
            if ("Y".equals(deleteflag)) {
                File file = new File(filepath + "report\\" + activity_id
                        + "\\01\\" + ids[i]);
                if (file.exists())
                    FileHelper.cleanDirectory(file);
            }
            this.doPicture(activity_id, Integer.parseInt(ids[i]));
            List<TSingleReport> tList = activityVolumeService.getByHql(
                    "from TSingleReport where activityId = ? and userId = ?",
                    new Object[] { activity_id, Integer.parseInt(ids[i]) });
            List<String> pdflist = new ArrayList();
            Collections.sort(tList);
            for (TSingleReport tsr : tList) {
                if (tsr.getUnitId() == 5 || tsr.getUnitId() == 7
                        || tsr.getUnitId() == 8 || tsr.getUnitId() == 3)
                    continue;
                if (tsr.getUnitId() == 10) {
                    List<Map> list = answerService.getKaiFangXingWenTi(
                            activity_id, Integer.parseInt(ids[i]),
                            activityVolumeService
                                    .getVolumeIdByActivityId(activity_id));
                    for (int j = 0; j < list.size(); j++) {
                        DataStore.getMap().put(tsr.getUserId() + "-" + j,
                                list.get(j));
                        String pdfpath = filepath + "report\\"
                                + tsr.getActivityId() + "\\01\\"
                                + tsr.getUserId() + "\\" + tsr.getUnitId()
                                + "-" + j + ".pdf";
                        String url_path = urlpath
                                + "/hrod/pdf.action?function=OpenPdf&user_id="
                                + tsr.getUserId() + "&activity_id="
                                + tsr.getActivityId() + "&unit_id="
                                + tsr.getUserId() + "-" + j;
                        if (new File(pdfpath).exists()) {
                            pdflist.add(pdfpath);
                            continue;
                        }
                        PdfUtils.toPdf(pdfpath, url_path, 0);
                        pdflist.add(pdfpath);
                    }

                } else {
                    String pdfpath = filepath + "report\\"
                            + tsr.getActivityId() + "\\01\\" + tsr.getUserId()
                            + "\\" + tsr.getUnitId() + ".pdf";
                    String url_path = urlpath
                            + "/hrod/pdf.action?function=OpenPdf&user_id="
                            + tsr.getUserId() + "&activity_id="
                            + tsr.getActivityId() + "&unit_id="
                            + tsr.getUnitId();
                    if (new File(pdfpath).exists()) {
                        pdflist.add(pdfpath);
                        continue;
                    }
                    if (tsr.getUnitId() == 1) {
                        PdfUtils.toPdf(pdfpath, url_path, 1);
                    } else {
                        PdfUtils.toPdf(pdfpath, url_path, 0);
                    }
                    pdflist.add(pdfpath);
                }
            }
            PDFMergerUtility mergePdf = new PDFMergerUtility();
            for (String spa : pdflist) {
                if (!new File(spa).exists())
                    continue;
                mergePdf.addSource(spa);
            }
            mergePdf.setDestinationFileName(filepath + "report\\" + activity_id
                    + "\\01\\" + ids[i] + "\\" + ids[i] + ".pdf");
            try {
                mergePdf.mergeDocuments();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        ResponseHelper.print(getResponse(), "SUC");
        return null;
    }

    public String doPicture(int activity_id, int user_id) {

        boolean btype = activityVolumeService.ifLevel(activity_id);  // 判断活动类型 关键行为：true  行为等级：false
        int volume_id = 0;
        LinkedList<DataRow> linked = null;

        TActivityVolume ftav = (TActivityVolume) activityVolumeService
                .getByHql("from TActivityVolume where activityId = ?",
                        new Object[] { activity_id }).get(0); // 获取活动套卷
        volume_id = ftav.getId();

        List<TSingleReport> trList = (List<TSingleReport>) activityVolumeService
                .getByHql(
                        "from TSingleReport where activity_id = ? and userId = ? order by cast(seqOrder as int)",
                        new Object[] { activity_id, user_id }); // 个人报告

        TActivityVolume tav = (TActivityVolume) activityVolumeService.getByHql( // 获取活动套卷与前面的重复？
                "from TActivityVolume where activityId = ?",
                new Object[] { activity_id }).get(0);
        List<TActivitySubject> subList = activityVolumeService
                .getByHql(
                        "from TActivitySubject where volumeID = ? and subType = 0 and worth is null", // 获取活动指标信息
                        new Object[] { tav.getId() });
        if (trList == null || trList.size() == 0) {
            return "MODEL";
        }
        for (int x = 0; x < trList.size(); x++) {
            int unit_id = trList.get(x).getUnitId();
            switch (unit_id) {
            case 1: // 封面
                break;
            case 2: // 前言
                break;
            case 3: // 指标定义
                break;
            case 4: // 总得分统计
                String path4 = Configuration.getString("system.filePath")
                        + "report\\" + activity_id + "\\01\\" + user_id;
                File file = new File(path4);
                if (!file.exists())
                    file.mkdirs();
                else {
                    if (new File(path4 + "\\4-6.png").exists()) {
                        this.setAttribute("path4", "/hrod/report/"
                                + activity_id + "/01/" + user_id + "/4.png");
                        TSingleReport tsr = (TSingleReport) activityVolumeService
                                .getByHql(
                                        "from TSingleReport where activityId = ? and user_id = ? and unitId = ?",
                                        new Object[] { activity_id, user_id,
                                                unit_id }).get(0);
                        this.setAttribute("content4", tsr.getContent());
                        break;
                    }
                }
                List<DataRow> dList = new ArrayList<DataRow>();
                for (TActivitySubject tas : subList) {
                    DataRow row = new DataRow();
                    row.set("name", tas.getName());
                    String weight = tas.getWeight();
                    if ("".equals(weight)) {
                        row.set("number", "0");
                        row.set("max", 0);
                        row.set("min", 0);
                        row.set("id", tas.getId());
                        dList.add(row);
                        continue;
                    }
                    List anlist = null;
                    if ("2".equals(tas.getBehaviorType())) { // 行为等级
                        anlist = (List<TVolumeLevelAnswer>) activityVolumeService
                                .getByHql(
                                        "from TVolumeLevelAnswer where subjectId = ?",
                                        new Object[] { tas.getId() });
                    } else {
                        anlist = (List<TVolumeAnswer>) activityVolumeService
                                .getByHql(
                                        "from TVolumeAnswer where subjectId = ?",
                                        new Object[] { tas.getId() });
                    }
                    if (anlist == null || anlist.size() == 0)
                        continue;
                    String[] weis = weight.split("\\|");
                    Double result = 0.0;
                    for (String qz : weis) {
                        if ("".equals(qz)) {
                            continue;
                        }
                        String[] qzz = qz.split("_");
                        Map<String, String> map = (Map) activityVolumeService
                                .querySqlMap(
                                        "SELECT GET_SUBJECT_AVGSCORE(?,?,?,?,?,?) AVGSCORE FROM DUAL",
                                        new Object[] { tas.getId(),
                                                activity_id, user_id, 0,
                                                qzz[0], "SUBJECT" }).get(0);
                        if (map.containsValue("NONE")
                                || map.containsValue("null")
                                || map.containsValue(null)) {
                            row.set("number", "0");
                            continue;
                        }
                        result = result + Double.parseDouble(qzz[1]) / 100
                                * Double.parseDouble(map.get("AVGSCORE"));
                        System.out.println(Double.parseDouble(qzz[1]));
                        System.out.println(Double.parseDouble(map
                                .get("AVGSCORE")));
                        System.out.println(result);
                    }
                    row.set("number", MathHelper.getFloat(result, 2) + "");
                    Map<String, String> maxMap = (Map<String, String>) activityVolumeService
                            .querySqlMap(
                                    "SELECT GET_SUBJECT_AVGSCORE(?,?,?,?,?,?) AVGSCORE FROM DUAL",
                                    new Object[] { tas.getId(), activity_id,
                                            user_id, 0, "0", "MAX" }).get(0);

                    String[] avgs = maxMap.get("AVGSCORE").split("-");
                    row.set("max",
                            MathHelper.getFloat(Double.parseDouble(avgs[1]), 2));
                    row.set("min",
                            MathHelper.getFloat(Double.parseDouble(avgs[0]), 2));
                    row.set("id", tas.getId());
                    if (!btype) // 行为等级
                        row.set("levelname",
                                answerService.getSubjectDescription(
                                        tas.getId(),
                                        MathHelper.getFloat(
                                                Double.parseDouble(avgs[1]), 2)));
                    dList.add(row);
                }

                linked = new LinkedList<DataRow>();
                for (DataRow dr : dList) {
                    if (linked.size() == 0) {
                        linked.add(dr);
                        continue;
                    }
                    int linkedSize = linked.size();
                    for (int i = 0; i < linkedSize; i++) {
                        if (dr.getFloat("number") >= linked.get(i).getFloat(
                                "number")) {
                            linked.add(i, dr);
                            break;
                        }
                        if (i == linkedSize - 1) {
                            linked.add(dr);
                        }
                    }
                }

                ArrayList<DataRow> al = new ArrayList(linked);
                if (!btype)
                    BarLineChart.newBaseImage(al, path4 + "\\4.png");
                else
                    BarLineChartChoose.newBaseImage(al, path4 + "\\4.png");
                this.setAttribute("path4", "/hrod/report/" + activity_id
                        + "/01/" + user_id + "/4.png");
                String content4 = "被评价人在" + linked.getFirst().getString("name")
                        + "方面表现较好，在" + linked.getLast().getString("name")
                        + "方面可能有待加强。";
                this.setAttribute("content4", content4);
                TSingleReport tsr = (TSingleReport) activityVolumeService
                        .getByHql(
                                "from TSingleReport where activityId = ? and user_id = ? and unitId = ?",
                                new Object[] { activity_id, user_id, unit_id })
                        .get(0);
                tsr.setContent(content4);
                if (al.size() >= 2) {
                    String daoshuzhibiaoid = al.get(al.size() - 1).getString(
                            "id")
                            + "@@" + al.get(al.size() - 2).getString("id");
                    tsr.setReportPath(daoshuzhibiaoid);
                }
                activityVolumeService.updateActivityVolumeObject(tsr);
                // 被评价人在 分值前两项 方面表现较好，在 分值后两项 方面可能有待加强。
                break;
            case 5:
                String path5 = Configuration.getString("system.filePath")
                        + "report\\" + activity_id + "\\01\\" + user_id;
                File file5 = new File(path5);
                if (!file5.exists())
                    file5.mkdirs();
                else {
                    if (new File(path5 + "\\5.png").exists()) {
                        this.setAttribute("path5", "/hrod/report/"
                                + activity_id + "/01/" + user_id + "/5.png");
                        TSingleReport tsr5 = (TSingleReport) activityVolumeService
                                .getByHql(
                                        "from TSingleReport where activityId = ? and user_id = ? and unitId = ?",
                                        new Object[] { activity_id, user_id,
                                                unit_id }).get(0);
                        this.setAttribute("content5", tsr5.getContent());
                        break;
                    }
                }
                List<DataRow> dList5 = new ArrayList<DataRow>();
                for (TActivitySubject tas : subList) {
                    List<DataRow> list5 = answerService.getSubjectAvg(
                            tas.getId(), activity_id, user_id);

                    Map map5 = answerService.getSubjectSelf(tas.getId(),
                            activity_id, user_id);
                    if (map5.containsValue("NONE")
                            || map5.containsValue("null")
                            || map5.containsValue(null))
                        continue;
                    DataRow row5 = new DataRow();
                    double sef5 = ((BigDecimal) map5.get("AVGSCORE"))
                            .doubleValue() - list5.get(0).getDouble("number");
                    row5.set("number", sef5);
                    if (sef5 > 0) {
                        row5.set("height", "自评偏高");
                    } else {
                        row5.set("height", "自评偏低");
                    }
                    row5.set("name", tas.getName());
                    dList5.add(row5);
                }

                BarChartNew.toChart(dList5, path5 + "\\5.png");
                Collections.sort(dList5, new Comparator<DataRow>() {

                    @Override
                    public int compare(DataRow o1, DataRow o2) {
                        // TODO Auto-generated method stub
                        return Math.abs(o1.getDouble("number"))
                                - Math.abs(o2.getDouble("number")) > 0 ? -2 : 1;
                    }
                });
                this.setAttribute("path5", "/hrod/report/" + activity_id
                        + "/01/" + user_id + "/5.png");
                String content5 = "被评价人在" + dList5.get(0).getString("name")
                        + "," + dList5.get(1).getString("name")
                        + "方面的自我认知较他人感知的偏差较大";
                this.setAttribute("content5", content5);
                TSingleReport tsr5 = (TSingleReport) activityVolumeService
                        .getByHql(
                                "from TSingleReport where activityId = ? and user_id = ? and unitId = ?",
                                new Object[] { activity_id, user_id, unit_id })
                        .get(0);
                tsr5.setContent(content5);
                activityVolumeService.updateActivityVolumeObject(tsr5);
                break;
            case 6:
                List<TEnumValue> uList = SysLibrary.getMtypeList("USER_TYPE",
                        SysConfig.enumList);
                Map<String, String> userMap = new HashMap<String, String>();
                for (TEnumValue tev : uList) {
                    userMap.put(tev.getItemValue(), tev.getItemName());
                }
                String path6 = Configuration.getString("system.filePath")
                        + "report\\" + activity_id + "\\01\\" + user_id;
                File file6 = new File(path6);
                if (!file6.exists())
                    file6.mkdirs();
                else {
                    if (new File(path6 + "\\6.png").exists()) {
                        this.setAttribute("path6", "/hrod/report/"
                                + activity_id + "/01/" + user_id + "/6.png");
                        TSingleReport tsr6 = (TSingleReport) activityVolumeService
                                .getByHql(
                                        "from TSingleReport where activityId = ? and user_id = ? and unitId = ?",
                                        new Object[] { activity_id, user_id,
                                                unit_id }).get(0);
                        this.setAttribute("content6", tsr6.getContent());
                        break;
                    }
                }
                List<DataRow> dList6 = new ArrayList<DataRow>();
                double[] db6 = { -1D, -1D };
                ArrayList<DataBean> arraylist = new ArrayList();
                ArrayList<DataBean> arrayList = new ArrayList();
                List<Double> doubleList = new ArrayList<Double>();
                for (TActivitySubject tas : subList) {
                    doubleList.clear();
                    String userType = tas.getUserType();
                    String[] types = userType.split("\\|");
                    for (int i = 0; i < types.length && !"0".equals(types[i]); i++) {
                        DataRow dr = new DataRow();
                        Map map6 = answerService.getSubjectUserType(
                                tas.getId(), activity_id, user_id, types[i]);
                        if (map6 == null || "".equals(map6.get("AVGSCORE"))
                                || map6.get("AVGSCORE") == null) {
                            continue;
                        } else {
                            dr.set("number",
                                    ((BigDecimal) map6.get("AVGSCORE"))
                                            .doubleValue());
                            dr.set("user_type", userMap.get(types[i]));
                            dr.set("name", tas.getName());
                        }
                        dList6.add(dr);
                        doubleList.add(dr.getDouble("number"));
                    }
                    Collections.sort(doubleList);
                    if (doubleList.size() == 3) {
                        db6[0] = Math.abs(doubleList.get(1).doubleValue()
                                - doubleList.get(0).doubleValue());
                        db6[1] = Math.abs(doubleList.get(1).doubleValue()
                                - doubleList.get(2).doubleValue());
                        arrayList.add(new DataBean().setAbs(
                                Math.abs(doubleList.get(0).doubleValue()
                                        - doubleList.get(2).doubleValue()))
                                .setName(tas.getName()));
                    } else if (doubleList.size() == 2) {
                        db6[0] = Math.abs(doubleList.get(1).doubleValue()
                                - doubleList.get(0).doubleValue());
                        db6[1] = Math.abs(doubleList.get(1).doubleValue()
                                - doubleList.get(0).doubleValue());
                        arrayList.add(new DataBean().setAbs(
                                Math.abs(doubleList.get(0).doubleValue()
                                        - doubleList.get(1).doubleValue()))
                                .setName(tas.getName()));
                    }
                    arraylist.add(new DataBean().setAbs(
                            db6[0] < db6[1] ? db6[0] : db6[1]).setName(
                            tas.getName()));
                }
                Collections.sort(arraylist);
                Collections.sort(arrayList);
                Collections.reverse(arrayList);
                LineChart.toLineChart(dList6, path6 + "\\6.png");
                this.setAttribute("path6", "/hrod/report/" + activity_id
                        + "/01/" + user_id + "/6.png");
                String content6 = "被评价人在" + arrayList.get(0).getName()
                        + "方面不同评价者认知差异较大，在" + arraylist.get(0).getName()
                        + "方面评价者认知较一致。";
                this.setAttribute("content6", content6);
                TSingleReport tsr6 = (TSingleReport) activityVolumeService
                        .getByHql(
                                "from TSingleReport where activityId = ? and user_id = ? and unitId = ?",
                                new Object[] { activity_id, user_id, unit_id })
                        .get(0);
                tsr6.setContent(content6);
                activityVolumeService.updateActivityVolumeObject(tsr6);
                break;
            case 7:
                int avgid7 = this.getIntParameter("avgid");
                TSingleReport tsr7 = null;
                List<DataRow> dList7 = new ArrayList<DataRow>();
                String path7 = Configuration.getString("system.filePath")
                        + "report\\" + activity_id + "\\01\\" + user_id;
                File file7 = new File(path7);
                if (!file7.exists())
                    file7.mkdirs();
                else {
                    if (new File(path7 + "\\7.png").exists()) {
                        this.setAttribute("path7", "/hrod/report/"
                                + activity_id + "/01/" + user_id + "/7.png");
                        tsr7 = (TSingleReport) activityVolumeService
                                .getByHql(
                                        "from TSingleReport where activityId = ? and user_id = ? and unitId = ?",
                                        new Object[] { activity_id, user_id,
                                                unit_id }).get(0);
                        this.setAttribute("content7", tsr7.getContent());
                        this.setAttribute("pathid7",
                                "/hrod/reportsubmit.action?function=EditAvgScore&activity_id="
                                        + activity_id + "&user_id=" + user_id
                                        + "&reportid=" + tsr7.getId()
                                        + "&avgid=" + tsr7.getModelId());
                        break;
                    }
                }
                String avgsql = "SELECT AVGID,COUNT(*) COUNTID FROM "
                        + "( SELECT DISTINCT B.AVGID,A.NAME FROM T_ACTIVITY_SUBJECT A,"
                        + "T_SUBJECT_AVG_DETAIL B,T_SUBJECT_AVG C "
                        + "WHERE A.NAME = B.SUBJECT_NAME AND A.BEHAVIOR_TYPE = "
                        + "C.SUBJECTTYPE AND C.ID = B.AVGID AND B.AVGID = "
                        + "B.AVGID AND A.VOLUME_ID = ? AND B.SUBJECT_SCORE IS NOT NULL AND A.WORTH IS NULL ) "
                        + "GROUP BY AVGID HAVING COUNT(*) = ?";
                List<Map> avgList = activityVolumeService.querySqlMap(avgsql,
                        new Object[] { volume_id, subList.size() });

                if (avgList == null || avgList.size() == 0) {
                    this.setAttribute("path7", "#");
                    this.setAttribute("avgid", "0");
                    this.setAttribute("pathid7", "#");
                } else {
                    int avgid = Integer.parseInt(avgList.get(0).get("AVGID")
                            .toString());
                    this.setAttribute("pathid7",
                            "/hrod/reportsubmit.action?function=EditAvgScore&activity_id="
                                    + activity_id + "&unit_id=10&user_id="
                                    + user_id + "&avgid=" + avgid);
                    TSubjectAvg subjectavg = (TSubjectAvg) activityVolumeService
                            .getByHql("from TSubjectAvg where id = ?",
                                    new Object[] { avgid }).get(0);
                    this.setAttribute("avgid", avgid);
                    List<TSubjectAvgDetail> avgDetailList = activityVolumeService
                            .getByHql("from TSubjectAvgDetail where avgid = ?",
                                    new Object[] { avgid });
                    List<DataBean7> db7List = new ArrayList();
                    List<DataRow> lineList7 = new ArrayList();
                    for (TActivitySubject tas7 : subList) {
                        TSubjectAvgDetail tsad = (TSubjectAvgDetail) activityVolumeService
                                .getByHql(
                                        "from TSubjectAvgDetail where avgid = ? and subjectName = ?",
                                        new Object[] { avgid, tas7.getName() })
                                .get(0);
                        DataRow subjectList7Temp = (DataRow) answerService
                                .getSubjectAvg(tas7.getId(), activity_id,
                                        user_id).get(0);

                        DataBean7 db7 = new DataBean7();
                        db7.setD7(Double.parseDouble(tsad.getSubjectScore())
                                - subjectList7Temp.getDouble("number"));
                        db7.setSubjectid(tas7.getId());
                        db7.setName(tas7.getName());
                        db7List.add(db7);

                        DataRow dr1 = new DataRow();
                        DataRow dr2 = new DataRow();
                        dr1.set("name", tas7.getName());
                        dr1.set("user_type", subjectavg.getAvgname());
                        dr1.set("number",
                                Double.parseDouble(tsad.getSubjectScore()));
                        lineList7.add(dr1);
                        dr2.set("name", tas7.getName());
                        dr2.set("user_type", "被评价人得分");
                        dr2.set("number", subjectList7Temp.getDouble("number"));
                        lineList7.add(dr2);

                    }
                    LineChart.toLineChart(lineList7, path7 + "\\7.png");
                    Collections.sort(db7List);
                    this.setAttribute("path7", "/hrod/report/" + activity_id
                            + "/01/" + user_id + "/7.png");
                    if (tsr7 == null || "".equals(tsr7.getContent())) {
                        String content7 = "被评价人在" + db7List.get(0).getName()
                                + "," + db7List.get(1).getName()
                                + "方面可能较群体平均水平更良好，在"
                                + db7List.get(db7List.size() - 1).getName()
                                + ","
                                + db7List.get(db7List.size() - 2).getName()
                                + "方面可能较群体平均水平偏弱";
                        this.setAttribute("content7", content7);
                        tsr7 = (TSingleReport) activityVolumeService
                                .getByHql(
                                        "from TSingleReport where activityId = ? and user_id = ? and unitId = ?",
                                        new Object[] { activity_id, user_id,
                                                unit_id }).get(0);
                        tsr7.setModelId(avgid);
                        tsr7.setContent(content7);
                        activityVolumeService.updateActivityVolumeObject(tsr7);
                    }
                }

                break;
            case 8:

                String path8 = Configuration.getString("system.filePath")
                        + "report\\" + activity_id + "\\01\\" + user_id;
                File file8 = new File(path8);
                TSingleReport tsr8 = null;
                if (!file8.exists())
                    file8.mkdirs();
                else {
                    if (new File(path8 + "\\8.png").exists()) {
                        this.setAttribute("path8", "/hrod/report/"
                                + activity_id + "/01/" + user_id + "/8.png");
                        tsr8 = (TSingleReport) activityVolumeService
                                .getByHql(
                                        "from TSingleReport where activityId = ? and user_id = ? and unitId = ?",
                                        new Object[] { activity_id, user_id,
                                                unit_id }).get(0);
                        this.setAttribute("content8", tsr8.getContent());
                        break;
                    }
                }

                TActivityUser tau8 = (TActivityUser) activityVolumeService
                        .getByHql("from TActivityUser where id = ?",
                                new Object[] { user_id }).get(0);
                /*
                 * List<TActivity> aList = activityVolumeService.getByHql(
                 * "select a from TActivity a inner join TActivityUser b on a.id = b.activityId "
                 * + " where b.userid = ? order by createDate desc", new
                 * Object[] { tau8.getUserid() });
                 */
                List<TActivity> aList = activityVolumeService
                        .getByHql(
                                "select a from TActivity a,TActivityUser b where a.id = b.activityId and b.userid = ? order by a.createDate desc",
                                new Object[] { tau8.getUserid() });
                int activity_old_id = 0;
                TActivity tactivity = null;
                for (TActivity ta : aList) {
                    if (answerService.judgeActivityMatch(subList.size(),
                            activity_id, ta.getId())) {
                        activity_old_id = ta.getId();
                        tactivity = ta;
                        break;
                    }
                }
                if (activity_old_id > 0) {
                    TActivityUser otau = (TActivityUser) activityVolumeService
                            .getByHql(
                                    "from TActivityUser where activityId = ? and userid = ?",
                                    new Object[] { activity_old_id,
                                            tau8.getUserid() }).get(0);
                    TActivityVolume tav_old = (TActivityVolume) activityVolumeService
                            .getByHql(
                                    "from TActivityVolume where activityId = ?",
                                    new Object[] { activity_old_id }).get(0);
                    List<DataBean7> ckList8 = new ArrayList<DataBean7>();
                    List<DataRow> list8 = new ArrayList<DataRow>();
                    List<TActivitySubject> oldSubList = activityVolumeService
                            .getByHql(
                                    "from TActivitySubject where volumeID = ?",
                                    new Object[] { tav_old.getId() });
                    for (TActivitySubject tas : subList) {
                        for (TActivitySubject oldtas : oldSubList) {
                            if (tas.getName().equals(oldtas.getName())) {
                                DataRow dr1 = new DataRow();
                                DataRow dr2 = new DataRow();
                                List<DataRow> nList8 = answerService
                                        .getSubjectAvg(tas.getId(),
                                                activity_id, user_id);
                                List<DataRow> oList8 = answerService
                                        .getSubjectAvg(oldtas.getId(),
                                                activity_old_id, otau.getId());

                                DataRow ndr = nList8.get(0);
                                DataRow odr = oList8.get(0);
                                DataBean7 db8 = new DataBean7();
                                db8.setD7(ndr.getDouble("number")
                                        - ndr.getDouble("number"));
                                db8.setName(tas.getName());
                                db8.setSubjectid(tas.getId());
                                ckList8.add(db8);

                                dr1.set("name", tas.getName());
                                dr1.set("user_type", "被评价人得分");
                                dr1.set("number", ndr.getDouble("number"));
                                list8.add(dr1);
                                dr2.set("name", tas.getName());
                                dr2.set("user_type", tactivity.getName());
                                dr2.set("number", ndr.getDouble("number"));
                                list8.add(dr2);
                            }
                        }
                    }

                    Collections.sort(ckList8);
                    LineChart.toLineChart(list8, path8 + "\\8.png");
                    this.setAttribute("path8", "/hrod/report/" + activity_id
                            + "/01/" + user_id + "/8.png");

                    if (tsr8 == null || "".equals(tsr8.getContent())) {
                        String content8 = "被评价人在" + ckList8.get(0).getName()
                                + "," + ckList8.get(0).getName() + "方面可能有提升。";
                        this.setAttribute("content8", content8);
                        tsr8 = (TSingleReport) activityVolumeService
                                .getByHql(
                                        "from TSingleReport where activityId = ? and user_id = ? and unitId = ?",
                                        new Object[] { activity_id, user_id,
                                                unit_id }).get(0);
                        tsr8.setContent(content8);
                        activityVolumeService.updateActivityVolumeObject(tsr8);
                    }
                }
                break;
            case 9:
                TSingleReport tsr4 = (TSingleReport) activityVolumeService
                        .getByHql(
                                "from TSingleReport where activityId = ? and user_id = ? and unitId = ?",
                                new Object[] { activity_id, user_id, 4 })
                        .get(0);
                if (tsr4.getReportPath() == null
                        || "".equals(tsr4.getReportPath())) {
                    break;
                }
                String subjectids = tsr4.getReportPath();
                String[] ids = subjectids.split("@@");
                ids[0] = activityVolumeService.getSubject(
                        Integer.parseInt(ids[0])).getSubjectId()
                        + "";
                ids[1] = activityVolumeService.getSubject(
                        Integer.parseInt(ids[1])).getSubjectId()
                        + "";
                if ("".equals(ids[0]) || "".equals(ids[1]))
                    break;

                String sql9 = "SELECT DISTINCT CONTENT,ITEM_NAME,P.NAME,ITEM_VALUE FROM T_SUGGEST M,T_ENUM_VALUE N,T_SUBJECT P "
                        + "WHERE M.TYPE = N.ITEM_VALUE AND P.ID = M.SUBJECT_ID AND "
                        + "ENUM_TYPE = 'DEVELOP_TYPE' AND M.SUBJECT_ID = ? ORDER BY ITEM_VALUE";

                String sql_9 = "SELECT DISTINCT ITEM_NAME,ITEM_VALUE FROM T_SUGGEST M,T_ENUM_VALUE N,T_SUBJECT P "
                        + "WHERE M.TYPE = N.ITEM_VALUE AND P.ID = M.SUBJECT_ID AND "
                        + "ENUM_TYPE = 'DEVELOP_TYPE' AND M.SUBJECT_ID = ? ORDER BY ITEM_VALUE";

                List<Map> tempName = activityVolumeService.querySqlMap(sql_9,
                        new Object[] { Integer.parseInt(ids[0]) });
                List<Map> tempName1 = activityVolumeService.querySqlMap(sql_9,
                        new Object[] { Integer.parseInt(ids[1]) });

                List<Map> list_91 = activityVolumeService.querySqlMap(sql9,
                        new Object[] { Integer.parseInt(ids[0]) });
                List<DataBeanTemp> list91 = new ArrayList();
                List<DataBeanTemp> list92 = new ArrayList();
                String subject1 = "";
                String subject2 = "";
                for (Map map : tempName) {
                    DataBeanTemp dbt = new DataBeanTemp();
                    dbt.setName(map.get("ITEM_NAME") + "");
                    dbt.setMlist(new ArrayList<Map>());
                    for (Map smap : list_91) {
                        subject1 = smap.get("NAME") + "";
                        if ((map.get("ITEM_NAME") + "").equals(smap
                                .get("ITEM_NAME") + "")) {
                            Map tMap = new HashMap();
                            tMap.put("NAME", smap.get("NAME"));
                            tMap.put("CONTENT", smap.get("CONTENT"));
                            dbt.getMlist().add(tMap);
                        }
                    }
                    list91.add(dbt);
                }
                List<Map> list_92 = activityVolumeService.querySqlMap(sql9,
                        new Object[] { Integer.parseInt(ids[1]) });
                for (Map map : tempName1) {
                    DataBeanTemp dbt = new DataBeanTemp();
                    dbt.setName(map.get("ITEM_NAME") + "");
                    dbt.setMlist(new ArrayList<Map>());
                    for (Map smap : list_92) {
                        subject2 = smap.get("NAME") + "";
                        if ((map.get("ITEM_NAME") + "").equals(smap
                                .get("ITEM_NAME") + "")) {
                            Map tMap = new HashMap();
                            tMap.put("NAME", smap.get("NAME"));
                            tMap.put("CONTENT", smap.get("CONTENT"));
                            dbt.getMlist().add(tMap);
                        }
                    }
                    list92.add(dbt);
                }
                this.setAttribute("list91", list91);
                this.setAttribute("list92", list92);
                this.setAttribute("subject1", subject1);
                this.setAttribute("subject2", subject2);
                break;
            case 10:
                List<SubjectMatrix> ysList = new ArrayList<SubjectMatrix>();
                List<SubjectMatrix> jqList = new ArrayList<SubjectMatrix>();
                TSingleReport tsr10 = (TSingleReport) activityVolumeService
                        .getByHql(
                                "from TSingleReport where activityId = ? and user_id = ? and unitId = ?",
                                new Object[] { activity_id, user_id, unit_id })
                        .get(0);
                if (tsr10 != null && tsr10.getContent() != null
                        && !"".equals(tsr10.getContent())) {
                    JSONObject json_content = JSONObject.fromObject(tsr10
                            .getContent());
                    JSONArray ys = json_content.getJSONArray("ys");
                    JSONArray jq = json_content.getJSONArray("jq");
                    for (int i = 0; i < ys.size(); i++) {
                        SubjectMatrix ys_sm = new SubjectMatrix();
                        JSONObject json = (JSONObject) ys.get(i);
                        ys_sm.setName(json.getString("title"));
                        String slist_str = json.getString("slist");
                        List<String> slist = new ArrayList<String>();
                        slist = Arrays.asList(slist_str.split("\\r\\n"));
                        ys_sm.setSlist(slist);
                        ysList.add(ys_sm);
                    }
                    for (int j = 0; j < jq.size(); j++) {
                        SubjectMatrix jq_sm = new SubjectMatrix();
                        JSONObject json = (JSONObject) jq.get(j);
                        jq_sm.setName(json.getString("title"));
                        String slist_str = json.getString("slist");
                        List<String> slist = new ArrayList<String>();
                        slist = Arrays.asList(slist_str.split("\\r\\n"));
                        jq_sm.setSlist(slist);
                        jqList.add(jq_sm);
                    }
                } else {
                    List<Map<String, String>> list10 = activityVolumeService
                            .querySqlMap(
                                    "SELECT DISTINCT A.SUBJECT_ID, B.NAME, C.TITLE, A.ANSWER_CONTENT FROM "
                                            + " T_VOLUME_ANSWER A, T_ACTIVITY_SUBJECT B, T_ACTIVITY_QUEST C WHERE  "
                                            + " A.SUBJECT_ID = B.ID AND B.ID = C.SUBJECT_ID AND A.QUE_ID = C.ID AND A.VOLUME_ID = ? "
                                            + "AND MATRIX = 1 AND A.ANSWER_CONTENT IS NOT NULL AND A.USER_ID = ?"
                                            + " ORDER BY NAME,TITLE",
                                    new Object[] { volume_id, user_id });
                    for (Map<String, String> map : list10) {
                        if (map.get("NAME").indexOf("优势") >= 0) {
                            if (ysList.size() == 0) {
                                SubjectMatrix smys = new SubjectMatrix();
                                List<String> sList = new ArrayList<String>();
                                sList.add(map.get("ANSWER_CONTENT"));
                                smys.setSlist(sList);
                                smys.setName(map.get("TITLE"));
                                ysList.add(smys);
                            } else {
                                int ysListSize = ysList.size();
                                for (int i = 0; i < ysListSize; i++) {
                                    if (ysList.get(i).getName()
                                            .equals(map.get("TITLE"))) {
                                        ysList.get(i).getSlist()
                                                .add(map.get("ANSWER_CONTENT"));
                                    } else if (i == ysListSize - 1) {
                                        SubjectMatrix smys = new SubjectMatrix();
                                        List<String> sList = new ArrayList<String>();
                                        sList.add(map.get("ANSWER_CONTENT"));
                                        smys.setSlist(sList);
                                        smys.setName(map.get("TITLE"));
                                        ysList.add(smys);
                                    }
                                }
                            }
                        } else {
                            if (jqList.size() == 0) {
                                SubjectMatrix smjq = new SubjectMatrix();
                                List<String> sList = new ArrayList<String>();
                                sList.add(map.get("ANSWER_CONTENT"));
                                smjq.setSlist(sList);
                                smjq.setName(map.get("TITLE"));
                                jqList.add(smjq);
                            } else {
                                int jqListSize = jqList.size();
                                for (int i = 0; i < jqListSize; i++) {
                                    if (jqList.get(i).getName()
                                            .equals(map.get("TITLE"))) {
                                        jqList.get(i).getSlist()
                                                .add(map.get("ANSWER_CONTENT"));
                                    } else if (i == jqListSize - 1) {
                                        SubjectMatrix smjq = new SubjectMatrix();
                                        List<String> sList = new ArrayList<String>();
                                        sList.add(map.get("ANSWER_CONTENT"));
                                        smjq.setSlist(sList);
                                        smjq.setName(map.get("TITLE"));
                                        jqList.add(smjq);
                                    }
                                }
                            }
                        }
                    }
                }
                this.setAttribute("ysList", ysList);
                this.setAttribute("jqList", jqList);
                break;
            case 11:
                List<String> listys = new ArrayList<String>();
                List<String> listjq = new ArrayList<String>();
                TSingleReport tsr11 = (TSingleReport) activityVolumeService
                        .getByHql(
                                "from TSingleReport where activityId = ? and user_id = ? and unitId = ?",
                                new Object[] { activity_id, user_id, unit_id })
                        .get(0);
                if (tsr11 != null && tsr11.getContent() != null
                        && !"".equals(tsr11.getContent())) {
                    JSONObject json_content = JSONObject.fromObject(tsr11
                            .getContent());
                    String ys = json_content.getString("ys");
                    String jq = json_content.getString("jq");
                    String[] arry_ys = ys.split("\\r\\n");
                    String[] arry_jq = jq.split("\\r\\n");
                    for (int i = 0; i < arry_ys.length; i++) {
                        listys.add(arry_ys[i]);
                    }
                    for (int j = 0; j < arry_jq.length; j++) {
                        listjq.add(arry_jq[j]);
                    }
                }
                this.setAttribute("listys", listys);
                this.setAttribute("listjq", listjq);
                break;
            default:
                break;
            }
        }
        return "SUCCESS";
    }
}
