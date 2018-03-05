import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.*;
import net.fortuna.ical4j.model.component.VAlarm;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VTimeZone;
import net.fortuna.ical4j.model.property.*;
import net.fortuna.ical4j.util.UidGenerator;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {

    public static void main(String[] args) throws IOException, ParserException {
        LocalDateTime firstDay = LocalDateTime.of(2018, 3, 5, 0, 0, 0, 0);
        LocalTime oneStart = LocalTime.of(8, 0);
        LocalTime oneEnd = LocalTime.of(9, 45);
        LocalTime twoStart = LocalTime.of(10, 15);
        LocalTime twoEnd = LocalTime.of(12, 0);
        LocalTime threeStart = LocalTime.of(14, 0);
        LocalTime threeEnd = LocalTime.of(15, 45);
        LocalTime fourStart = LocalTime.of(16, 15);
        LocalTime fourEnd = LocalTime.of(18, 0);
        LocalTime fiveStart = LocalTime.of(19, 0);
        LocalTime fiveEnd = LocalTime.of(20, 45);
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = firstDay.atZone(zoneId);

        java.util.Date date = Date.from(zdt.toInstant());

        String in = "src/main/resources/Shanghai.ics";
        String out = "src/main/resources/kcb.ics";
        String kcbJson = "{\"xskbsfxstkzt\":\"0\",\"kblx\":7,\"xsxx\":{\"XH_ID\":\"09153810\",\"XQMMC\":\"2\",\"XNM\":\"2017\",\"XH\":\"09153810\",\"XKKG\":\"1\",\"XKKGXQ\":\"1~('12')\",\"KXKXXQ\":\"('12')\",\"XNMC\":\"2017-2018\",\"XQM\":\"12\",\"XM\":\"冯楚\"},\"sjkList\":[{\"jgpxzd\":\"1\",\"kcmc\":\"专业实习●\",\"listnav\":\"false\",\"localeKey\":\"zh_CN\",\"pageable\":true,\"qsz\":\"20\",\"queryModel\":{\"currentPage\":1,\"currentResult\":0,\"entityOrField\":false,\"limit\":15,\"offset\":0,\"pageNo\":0,\"pageSize\":15,\"showCount\":10,\"totalCount\":0,\"totalPage\":0,\"totalResult\":0},\"rangeable\":true,\"rsdzjs\":0,\"sfsjk\":\"1\",\"totalResult\":\"0\",\"userModel\":{\"monitor\":false,\"roleCount\":0,\"roleKeys\":\"\",\"roleValues\":\"\",\"status\":0,\"usable\":false},\"xm\":\"王辉1\",\"zhxs\":\"1\",\"zzz\":\"20\"},{\"jgpxzd\":\"1\",\"kcmc\":\"专业导论与学科前沿讲座●\",\"listnav\":\"false\",\"localeKey\":\"zh_CN\",\"pageable\":true,\"qsz\":\"20\",\"queryModel\":{\"currentPage\":1,\"currentResult\":0,\"entityOrField\":false,\"limit\":15,\"offset\":0,\"pageNo\":0,\"pageSize\":15,\"showCount\":10,\"totalCount\":0,\"totalPage\":0,\"totalResult\":0},\"rangeable\":true,\"rsdzjs\":0,\"sfsjk\":\"1\",\"totalResult\":\"0\",\"userModel\":{\"monitor\":false,\"roleCount\":0,\"roleKeys\":\"\",\"roleValues\":\"\",\"status\":0,\"usable\":false},\"xm\":\"王辉1\",\"zhxs\":\"1\",\"zzz\":\"20\"},{\"jgpxzd\":\"1\",\"kcmc\":\"电子商务理论与实务训练（4）●\",\"listnav\":\"false\",\"localeKey\":\"zh_CN\",\"pageable\":true,\"qsz\":\"20\",\"queryModel\":{\"currentPage\":1,\"currentResult\":0,\"entityOrField\":false,\"limit\":15,\"offset\":0,\"pageNo\":0,\"pageSize\":15,\"showCount\":10,\"totalCount\":0,\"totalPage\":0,\"totalResult\":0},\"rangeable\":true,\"rsdzjs\":0,\"sfsjk\":\"1\",\"totalResult\":\"0\",\"userModel\":{\"monitor\":false,\"roleCount\":0,\"roleKeys\":\"\",\"roleValues\":\"\",\"status\":0,\"usable\":false},\"xm\":\"王贺朝,张卫华,杨明智\",\"zhxs\":\"1\",\"zzz\":\"20\"}],\"kbList\":[{\"cd_id\":\"sgw0000524\",\"cdmc\":\"博1-B503\",\"jc\":\"3-4节\",\"jcor\":\"3-4\",\"jcs\":\"3-4\",\"jgh_id\":\"090209\",\"jgpxzd\":\"1\",\"jxb_id\":\"5FC994C6550B0000E053C0A86D5D731E\",\"jxbmc\":\"公司理财-0001\",\"kch_id\":\"1102100609COFI\",\"kcmc\":\"公司理财\",\"khfsmc\":\"未安排\",\"listnav\":\"false\",\"localeKey\":\"zh_CN\",\"oldjc\":\"12\",\"oldzc\":\"255\",\"pageable\":true,\"pkbj\":\"1\",\"queryModel\":{\"currentPage\":1,\"currentResult\":0,\"entityOrField\":false,\"limit\":15,\"offset\":0,\"pageNo\":0,\"pageSize\":15,\"showCount\":10,\"totalCount\":0,\"totalPage\":0,\"totalResult\":0},\"rangeable\":true,\"rsdzjs\":0,\"sxbj\":\"1\",\"totalResult\":\"0\",\"userModel\":{\"monitor\":false,\"roleCount\":0,\"roleKeys\":\"\",\"roleValues\":\"\",\"status\":0,\"usable\":false},\"xm\":\"张涛1\",\"xnm\":\"2017\",\"xqdm\":\"0\",\"xqh_id\":\"2\",\"xqj\":\"1\",\"xqjmc\":\"星期一\",\"xqm\":\"12\",\"xqmc\":\"南湖校区\",\"xsdm\":\"01\",\"xslxbj\":\"★\",\"zcd\":\"1-8周\",\"zcmc\":\"讲师\",\"zyfxmc\":\"无方向\"},{\"cd_id\":\"sgw0001228\",\"cdmc\":\"博2-A302\",\"jc\":\"5-6节\",\"jcor\":\"5-6\",\"jcs\":\"5-6\",\"jgh_id\":\"090073\",\"jgpxzd\":\"1\",\"jxb_id\":\"5FA79856E5B90254E053C0A86D5D76E0\",\"jxbmc\":\"电子金融与安全-0001\",\"kch_id\":\"1108220509EFAS\",\"kcmc\":\"电子金融与安全\",\"khfsmc\":\"未安排\",\"listnav\":\"false\",\"localeKey\":\"zh_CN\",\"oldjc\":\"48\",\"oldzc\":\"255\",\"pageable\":true,\"pkbj\":\"1\",\"queryModel\":{\"currentPage\":1,\"currentResult\":0,\"entityOrField\":false,\"limit\":15,\"offset\":0,\"pageNo\":0,\"pageSize\":15,\"showCount\":10,\"totalCount\":0,\"totalPage\":0,\"totalResult\":0},\"rangeable\":true,\"rsdzjs\":0,\"sxbj\":\"1\",\"totalResult\":\"0\",\"userModel\":{\"monitor\":false,\"roleCount\":0,\"roleKeys\":\"\",\"roleValues\":\"\",\"status\":0,\"usable\":false},\"xm\":\"王贺朝\",\"xnm\":\"2017\",\"xqdm\":\"0\",\"xqh_id\":\"2\",\"xqj\":\"1\",\"xqjmc\":\"星期一\",\"xqm\":\"12\",\"xqmc\":\"南湖校区\",\"xsdm\":\"01\",\"xslxbj\":\"★\",\"zcd\":\"1-8周\",\"zcmc\":\"副教授\",\"zyfxmc\":\"无方向\"},{\"cd_id\":\"sgw0000533\",\"cdmc\":\"博1-B102\",\"jc\":\"3-4节\",\"jcor\":\"3-4\",\"jcs\":\"3-4\",\"jgh_id\":\"110069\",\"jgpxzd\":\"1\",\"jxb_id\":\"5F42373F7DDB0072E053C0A86D5CDB54\",\"jxbmc\":\"经济法-0001\",\"kch_id\":\"0301105311ECOL\",\"kcmc\":\"经济法\",\"khfsmc\":\"未安排\",\"listnav\":\"false\",\"localeKey\":\"zh_CN\",\"oldjc\":\"12\",\"oldzc\":\"255\",\"pageable\":true,\"pkbj\":\"1\",\"queryModel\":{\"currentPage\":1,\"currentResult\":0,\"entityOrField\":false,\"limit\":15,\"offset\":0,\"pageNo\":0,\"pageSize\":15,\"showCount\":10,\"totalCount\":0,\"totalPage\":0,\"totalResult\":0},\"rangeable\":true,\"rsdzjs\":0,\"sxbj\":\"1\",\"totalResult\":\"0\",\"userModel\":{\"monitor\":false,\"roleCount\":0,\"roleKeys\":\"\",\"roleValues\":\"\",\"status\":0,\"usable\":false},\"xm\":\"张小青\",\"xnm\":\"2017\",\"xqdm\":\"0\",\"xqh_id\":\"2\",\"xqj\":\"2\",\"xqjmc\":\"星期二\",\"xqm\":\"12\",\"xqmc\":\"南湖校区\",\"xsdm\":\"01\",\"xslxbj\":\"★\",\"zcd\":\"1-8周\",\"zcmc\":\"讲师\",\"zyfxmc\":\"无方向\"},{\"cd_id\":\"sgw0001060\",\"cdmc\":\"博2-B404\",\"jc\":\"3-4节\",\"jcor\":\"3-4\",\"jcs\":\"3-4\",\"jgh_id\":\"090206\",\"jgpxzd\":\"1\",\"jxb_id\":\"5FA6D3477FBE019EE053C0A86D5C4131\",\"jxbmc\":\"信息系统分析与设计-0001\",\"kch_id\":\"1108321309ISAD\",\"kcmc\":\"信息系统分析与设计\",\"khfsmc\":\"未安排\",\"listnav\":\"false\",\"localeKey\":\"zh_CN\",\"oldjc\":\"12\",\"oldzc\":\"130560\",\"pageable\":true,\"pkbj\":\"1\",\"queryModel\":{\"currentPage\":1,\"currentResult\":0,\"entityOrField\":false,\"limit\":15,\"offset\":0,\"pageNo\":0,\"pageSize\":15,\"showCount\":10,\"totalCount\":0,\"totalPage\":0,\"totalResult\":0},\"rangeable\":true,\"rsdzjs\":0,\"sxbj\":\"1\",\"totalResult\":\"0\",\"userModel\":{\"monitor\":false,\"roleCount\":0,\"roleKeys\":\"\",\"roleValues\":\"\",\"status\":0,\"usable\":false},\"xm\":\"杨明智\",\"xnm\":\"2017\",\"xqdm\":\"0\",\"xqh_id\":\"2\",\"xqj\":\"2\",\"xqjmc\":\"星期二\",\"xqm\":\"12\",\"xqmc\":\"南湖校区\",\"xsdm\":\"01\",\"xslxbj\":\"★\",\"zcd\":\"10-17周\",\"zcmc\":\"讲师\",\"zyfxmc\":\"无方向\"},{\"cd_id\":\"sgw0001060\",\"cdmc\":\"博2-B404\",\"jc\":\"5-6节\",\"jcor\":\"5-6\",\"jcs\":\"5-6\",\"jgh_id\":\"090197\",\"jgpxzd\":\"1\",\"jxb_id\":\"5F999D917F900054E053C0A86D5DBF56\",\"jxbmc\":\"网络营销-0001\",\"kch_id\":\"1108224209NETM\",\"kcmc\":\"网络营销\",\"khfsmc\":\"未安排\",\"listnav\":\"false\",\"localeKey\":\"zh_CN\",\"oldjc\":\"48\",\"oldzc\":\"261120\",\"pageable\":true,\"pkbj\":\"1\",\"queryModel\":{\"currentPage\":1,\"currentResult\":0,\"entityOrField\":false,\"limit\":15,\"offset\":0,\"pageNo\":0,\"pageSize\":15,\"showCount\":10,\"totalCount\":0,\"totalPage\":0,\"totalResult\":0},\"rangeable\":true,\"rsdzjs\":0,\"sxbj\":\"1\",\"totalResult\":\"0\",\"userModel\":{\"monitor\":false,\"roleCount\":0,\"roleKeys\":\"\",\"roleValues\":\"\",\"status\":0,\"usable\":false},\"xm\":\"张卫华\",\"xnm\":\"2017\",\"xqdm\":\"0\",\"xqh_id\":\"2\",\"xqj\":\"2\",\"xqjmc\":\"星期二\",\"xqm\":\"12\",\"xqmc\":\"南湖校区\",\"xsdm\":\"01\",\"xslxbj\":\"★\",\"zcd\":\"11-18周\",\"zcmc\":\"副教授\",\"zyfxmc\":\"无方向\"},{\"cd_id\":\"sgw0000567\",\"cdmc\":\"博1-B203\",\"jc\":\"1-2节\",\"jcor\":\"1-2\",\"jcs\":\"1-2\",\"jgh_id\":\"090209\",\"jgpxzd\":\"1\",\"jxb_id\":\"5FC994C6550B0000E053C0A86D5D731E\",\"jxbmc\":\"公司理财-0001\",\"kch_id\":\"1102100609COFI\",\"kcmc\":\"公司理财\",\"khfsmc\":\"未安排\",\"listnav\":\"false\",\"localeKey\":\"zh_CN\",\"oldjc\":\"3\",\"oldzc\":\"127\",\"pageable\":true,\"pkbj\":\"1\",\"queryModel\":{\"currentPage\":1,\"currentResult\":0,\"entityOrField\":false,\"limit\":15,\"offset\":0,\"pageNo\":0,\"pageSize\":15,\"showCount\":10,\"totalCount\":0,\"totalPage\":0,\"totalResult\":0},\"rangeable\":true,\"rsdzjs\":0,\"sxbj\":\"1\",\"totalResult\":\"0\",\"userModel\":{\"monitor\":false,\"roleCount\":0,\"roleKeys\":\"\",\"roleValues\":\"\",\"status\":0,\"usable\":false},\"xm\":\"张涛1\",\"xnm\":\"2017\",\"xqdm\":\"0\",\"xqh_id\":\"2\",\"xqj\":\"3\",\"xqjmc\":\"星期三\",\"xqm\":\"12\",\"xqmc\":\"南湖校区\",\"xsdm\":\"01\",\"xslxbj\":\"★\",\"zcd\":\"1-7周\",\"zcmc\":\"讲师\",\"zyfxmc\":\"无方向\"},{\"cd_id\":\"sgw0000911\",\"cdmc\":\"博2-A403\",\"jc\":\"3-4节\",\"jcor\":\"3-4\",\"jcs\":\"3-4\",\"jgh_id\":\"090073\",\"jgpxzd\":\"1\",\"jxb_id\":\"5FA79856E5B90254E053C0A86D5D76E0\",\"jxbmc\":\"电子金融与安全-0001\",\"kch_id\":\"1108220509EFAS\",\"kcmc\":\"电子金融与安全\",\"khfsmc\":\"未安排\",\"listnav\":\"false\",\"localeKey\":\"zh_CN\",\"oldjc\":\"12\",\"oldzc\":\"127\",\"pageable\":true,\"pkbj\":\"1\",\"queryModel\":{\"currentPage\":1,\"currentResult\":0,\"entityOrField\":false,\"limit\":15,\"offset\":0,\"pageNo\":0,\"pageSize\":15,\"showCount\":10,\"totalCount\":0,\"totalPage\":0,\"totalResult\":0},\"rangeable\":true,\"rsdzjs\":0,\"sxbj\":\"1\",\"totalResult\":\"0\",\"userModel\":{\"monitor\":false,\"roleCount\":0,\"roleKeys\":\"\",\"roleValues\":\"\",\"status\":0,\"usable\":false},\"xm\":\"王贺朝\",\"xnm\":\"2017\",\"xqdm\":\"0\",\"xqh_id\":\"2\",\"xqj\":\"3\",\"xqjmc\":\"星期三\",\"xqm\":\"12\",\"xqmc\":\"南湖校区\",\"xsdm\":\"01\",\"xslxbj\":\"★\",\"zcd\":\"1-7周\",\"zcmc\":\"副教授\",\"zyfxmc\":\"无方向\"},{\"cd_id\":\"sgw0001057\",\"cdmc\":\"博2-B202\",\"jc\":\"9-10节\",\"jcor\":\"9-10\",\"jcs\":\"9-10\",\"jgh_id\":\"090223\",\"jgpxzd\":\"1\",\"jxb_id\":\"5FA3FF5772B2021CE053C0A86D5DC1F2\",\"jxbmc\":\"电子商务专题-0001\",\"kch_id\":\"1108320709STEC\",\"kcmc\":\"电子商务专题\",\"khfsmc\":\"未安排\",\"listnav\":\"false\",\"localeKey\":\"zh_CN\",\"oldjc\":\"768\",\"oldzc\":\"2047\",\"pageable\":true,\"pkbj\":\"1\",\"queryModel\":{\"currentPage\":1,\"currentResult\":0,\"entityOrField\":false,\"limit\":15,\"offset\":0,\"pageNo\":0,\"pageSize\":15,\"showCount\":10,\"totalCount\":0,\"totalPage\":0,\"totalResult\":0},\"rangeable\":true,\"rsdzjs\":0,\"sxbj\":\"1\",\"totalResult\":\"0\",\"userModel\":{\"monitor\":false,\"roleCount\":0,\"roleKeys\":\"\",\"roleValues\":\"\",\"status\":0,\"usable\":false},\"xm\":\"张磊\",\"xnm\":\"2017\",\"xqdm\":\"0\",\"xqh_id\":\"2\",\"xqj\":\"3\",\"xqjmc\":\"星期三\",\"xqm\":\"12\",\"xqmc\":\"南湖校区\",\"xsdm\":\"01\",\"xslxbj\":\"★\",\"zcd\":\"1-11周\",\"zcmc\":\"教授\",\"zyfxmc\":\"无方向\"},{\"cd_id\":\"sgw0000425\",\"cdmc\":\"博2-A503\",\"jc\":\"3-4节\",\"jcor\":\"3-4\",\"jcs\":\"3-4\",\"jgh_id\":\"110069\",\"jgpxzd\":\"1\",\"jxb_id\":\"5F42373F7DDB0072E053C0A86D5CDB54\",\"jxbmc\":\"经济法-0001\",\"kch_id\":\"0301105311ECOL\",\"kcmc\":\"经济法\",\"khfsmc\":\"未安排\",\"listnav\":\"false\",\"localeKey\":\"zh_CN\",\"oldjc\":\"12\",\"oldzc\":\"495\",\"pageable\":true,\"pkbj\":\"1\",\"queryModel\":{\"currentPage\":1,\"currentResult\":0,\"entityOrField\":false,\"limit\":15,\"offset\":0,\"pageNo\":0,\"pageSize\":15,\"showCount\":10,\"totalCount\":0,\"totalPage\":0,\"totalResult\":0},\"rangeable\":true,\"rsdzjs\":0,\"sxbj\":\"1\",\"totalResult\":\"0\",\"userModel\":{\"monitor\":false,\"roleCount\":0,\"roleKeys\":\"\",\"roleValues\":\"\",\"status\":0,\"usable\":false},\"xm\":\"张小青\",\"xnm\":\"2017\",\"xqdm\":\"0\",\"xqh_id\":\"2\",\"xqj\":\"4\",\"xqjmc\":\"星期四\",\"xqm\":\"12\",\"xqmc\":\"南湖校区\",\"xsdm\":\"01\",\"xslxbj\":\"★\",\"zcd\":\"1-4周,6-9周\",\"zcmc\":\"讲师\",\"zyfxmc\":\"无方向\"},{\"cd_id\":\"sgw0001060\",\"cdmc\":\"博2-B404\",\"jc\":\"3-4节\",\"jcor\":\"3-4\",\"jcs\":\"3-4\",\"jgh_id\":\"090197\",\"jgpxzd\":\"1\",\"jxb_id\":\"5F999D917F900054E053C0A86D5DBF56\",\"jxbmc\":\"网络营销-0001\",\"kch_id\":\"1108224209NETM\",\"kcmc\":\"网络营销\",\"khfsmc\":\"未安排\",\"listnav\":\"false\",\"localeKey\":\"zh_CN\",\"oldjc\":\"12\",\"oldzc\":\"261120\",\"pageable\":true,\"pkbj\":\"1\",\"queryModel\":{\"currentPage\":1,\"currentResult\":0,\"entityOrField\":false,\"limit\":15,\"offset\":0,\"pageNo\":0,\"pageSize\":15,\"showCount\":10,\"totalCount\":0,\"totalPage\":0,\"totalResult\":0},\"rangeable\":true,\"rsdzjs\":0,\"sxbj\":\"1\",\"totalResult\":\"0\",\"userModel\":{\"monitor\":false,\"roleCount\":0,\"roleKeys\":\"\",\"roleValues\":\"\",\"status\":0,\"usable\":false},\"xm\":\"张卫华\",\"xnm\":\"2017\",\"xqdm\":\"0\",\"xqh_id\":\"2\",\"xqj\":\"4\",\"xqjmc\":\"星期四\",\"xqm\":\"12\",\"xqmc\":\"南湖校区\",\"xsdm\":\"01\",\"xslxbj\":\"★\",\"zcd\":\"11-18周\",\"zcmc\":\"副教授\",\"zyfxmc\":\"无方向\"},{\"cd_id\":\"sgw0001060\",\"cdmc\":\"博2-B404\",\"jc\":\"5-6节\",\"jcor\":\"5-6\",\"jcs\":\"5-6\",\"jgh_id\":\"090206\",\"jgpxzd\":\"1\",\"jxb_id\":\"5FA6D3477FBE019EE053C0A86D5C4131\",\"jxbmc\":\"信息系统分析与设计-0001\",\"kch_id\":\"1108321309ISAD\",\"kcmc\":\"信息系统分析与设计\",\"khfsmc\":\"未安排\",\"listnav\":\"false\",\"localeKey\":\"zh_CN\",\"oldjc\":\"48\",\"oldzc\":\"130560\",\"pageable\":true,\"pkbj\":\"1\",\"queryModel\":{\"currentPage\":1,\"currentResult\":0,\"entityOrField\":false,\"limit\":15,\"offset\":0,\"pageNo\":0,\"pageSize\":15,\"showCount\":10,\"totalCount\":0,\"totalPage\":0,\"totalResult\":0},\"rangeable\":true,\"rsdzjs\":0,\"sxbj\":\"1\",\"totalResult\":\"0\",\"userModel\":{\"monitor\":false,\"roleCount\":0,\"roleKeys\":\"\",\"roleValues\":\"\",\"status\":0,\"usable\":false},\"xm\":\"杨明智\",\"xnm\":\"2017\",\"xqdm\":\"0\",\"xqh_id\":\"2\",\"xqj\":\"4\",\"xqjmc\":\"星期四\",\"xqm\":\"12\",\"xqmc\":\"南湖校区\",\"xsdm\":\"01\",\"xslxbj\":\"★\",\"zcd\":\"10-17周\",\"zcmc\":\"讲师\",\"zyfxmc\":\"无方向\"},{\"cd_id\":\"sgw0000098\",\"cdmc\":\"博3-B302\",\"jc\":\"1-2节\",\"jcor\":\"1-2\",\"jcs\":\"1-2\",\"jgh_id\":\"090073\",\"jgpxzd\":\"1\",\"jxb_id\":\"5FA79856E5B90254E053C0A86D5D76E0\",\"jxbmc\":\"电子金融与安全-0001\",\"kch_id\":\"1108220509EFAS\",\"kcmc\":\"电子金融与安全\",\"khfsmc\":\"未安排\",\"listnav\":\"false\",\"localeKey\":\"zh_CN\",\"oldjc\":\"3\",\"oldzc\":\"79\",\"pageable\":true,\"pkbj\":\"1\",\"queryModel\":{\"currentPage\":1,\"currentResult\":0,\"entityOrField\":false,\"limit\":15,\"offset\":0,\"pageNo\":0,\"pageSize\":15,\"showCount\":10,\"totalCount\":0,\"totalPage\":0,\"totalResult\":0},\"rangeable\":true,\"rsdzjs\":0,\"sxbj\":\"1\",\"totalResult\":\"0\",\"userModel\":{\"monitor\":false,\"roleCount\":0,\"roleKeys\":\"\",\"roleValues\":\"\",\"status\":0,\"usable\":false},\"xm\":\"王贺朝\",\"xnm\":\"2017\",\"xqdm\":\"0\",\"xqh_id\":\"2\",\"xqj\":\"5\",\"xqjmc\":\"星期五\",\"xqm\":\"12\",\"xqmc\":\"南湖校区\",\"xsdm\":\"01\",\"xslxbj\":\"★\",\"zcd\":\"1-4周,7周\",\"zcmc\":\"副教授\",\"zyfxmc\":\"无方向\"},{\"cd_id\":\"sgw0000524\",\"cdmc\":\"博1-B503\",\"jc\":\"5-6节\",\"jcor\":\"5-6\",\"jcs\":\"5-6\",\"jgh_id\":\"090209\",\"jgpxzd\":\"1\",\"jxb_id\":\"5FC994C6550B0000E053C0A86D5D731E\",\"jxbmc\":\"公司理财-0001\",\"kch_id\":\"1102100609COFI\",\"kcmc\":\"公司理财\",\"khfsmc\":\"未安排\",\"listnav\":\"false\",\"localeKey\":\"zh_CN\",\"oldjc\":\"48\",\"oldzc\":\"79\",\"pageable\":true,\"pkbj\":\"1\",\"queryModel\":{\"currentPage\":1,\"currentResult\":0,\"entityOrField\":false,\"limit\":15,\"offset\":0,\"pageNo\":0,\"pageSize\":15,\"showCount\":10,\"totalCount\":0,\"totalPage\":0,\"totalResult\":0},\"rangeable\":true,\"rsdzjs\":0,\"sxbj\":\"1\",\"totalResult\":\"0\",\"userModel\":{\"monitor\":false,\"roleCount\":0,\"roleKeys\":\"\",\"roleValues\":\"\",\"status\":0,\"usable\":false},\"xm\":\"张涛1\",\"xnm\":\"2017\",\"xqdm\":\"0\",\"xqh_id\":\"2\",\"xqj\":\"5\",\"xqjmc\":\"星期五\",\"xqm\":\"12\",\"xqmc\":\"南湖校区\",\"xsdm\":\"01\",\"xslxbj\":\"★\",\"zcd\":\"1-4周,7周\",\"zcmc\":\"讲师\",\"zyfxmc\":\"无方向\"},{\"cd_id\":\"sgw0001057\",\"cdmc\":\"博2-B202\",\"jc\":\"7-8节\",\"jcor\":\"7-8\",\"jcs\":\"7-8\",\"jgh_id\":\"090223\",\"jgpxzd\":\"1\",\"jxb_id\":\"5FA3FF5772B2021CE053C0A86D5DC1F2\",\"jxbmc\":\"电子商务专题-0001\",\"kch_id\":\"1108320709STEC\",\"kcmc\":\"电子商务专题\",\"khfsmc\":\"未安排\",\"listnav\":\"false\",\"localeKey\":\"zh_CN\",\"oldjc\":\"192\",\"oldzc\":\"1999\",\"pageable\":true,\"pkbj\":\"1\",\"queryModel\":{\"currentPage\":1,\"currentResult\":0,\"entityOrField\":false,\"limit\":15,\"offset\":0,\"pageNo\":0,\"pageSize\":15,\"showCount\":10,\"totalCount\":0,\"totalPage\":0,\"totalResult\":0},\"rangeable\":true,\"rsdzjs\":0,\"sxbj\":\"1\",\"totalResult\":\"0\",\"userModel\":{\"monitor\":false,\"roleCount\":0,\"roleKeys\":\"\",\"roleValues\":\"\",\"status\":0,\"usable\":false},\"xm\":\"张磊\",\"xnm\":\"2017\",\"xqdm\":\"0\",\"xqh_id\":\"2\",\"xqj\":\"5\",\"xqjmc\":\"星期五\",\"xqm\":\"12\",\"xqmc\":\"南湖校区\",\"xsdm\":\"01\",\"xslxbj\":\"★\",\"zcd\":\"1-4周,7-11周\",\"zcmc\":\"教授\",\"zyfxmc\":\"无方向\"}],\"xkkg\":true,\"xqjmcMap\":{\"1\":\"星期一\",\"2\":\"星期二\",\"3\":\"星期三\",\"4\":\"星期四\",\"5\":\"星期五\",\"6\":\"星期六\",\"7\":\"星期日\"}}";

        JSONArray kbList = (JSONArray) JSONObject.fromObject(kcbJson).get("kbList");

//        FileInputStream fin = new FileInputStream(in);
//        CalendarBuilder builder = new CalendarBuilder();
//        Calendar icsCalendar= builder.build(fin);

        // 创建日历
        net.fortuna.ical4j.model.Calendar icsCalendar = new net.fortuna.ical4j.model.Calendar();
        icsCalendar.getProperties().add(new ProdId("-//Events Calendar//iCal4j 1.0//EN"));
        icsCalendar.getProperties().add(CalScale.GREGORIAN);
        icsCalendar.getProperties().add(Version.VERSION_2_0);


        // 创建一个时区（TimeZone）
        TimeZoneRegistry registry = new TimeZoneRegistryImpl("zoneinfo-outlook/");
//        TimeZoneRegistry registry = TimeZoneRegistryFactory.getInstance().createRegistry();
        TimeZone timezone = registry.getTimeZone("Asia/Shanghai");
        VTimeZone tz = timezone.getVTimeZone();
        icsCalendar.getComponents().add(tz);

        for (Object o : kbList) {
            JSONObject kbItem = JSONObject.fromObject(o);
            // 起始时间
            Integer dayOfWeek = Integer.valueOf(kbItem.getString("xqj"));
            String zcd = (String) kbItem.get("zcd");
            for (String s : zcd.split(",")) {
                Integer firstWeekWithLesson = null;
                Integer lastWeekWithLesson = null;
                if (s.indexOf("-") > 0) {
                    firstWeekWithLesson = Integer.valueOf(s.substring(0, s.indexOf("-")));
                    lastWeekWithLesson = Integer.valueOf(s.substring(s.indexOf("-") + 1, s.indexOf("周")));
                } else {
                    firstWeekWithLesson = Integer.valueOf(s.substring(0, s.indexOf("周")));
                    lastWeekWithLesson = firstWeekWithLesson;
                }

                LocalDateTime startDate = firstDay.plusDays(dayOfWeek - 1).plusWeeks(firstWeekWithLesson - 1);

                // 结束时间
                LocalDateTime endDate = firstDay.plusDays(dayOfWeek - 1).plusWeeks(firstWeekWithLesson - 1);

                switch ((String) kbItem.get("jcs")) {
                    case "1-2":
                        startDate = startDate.plusHours(oneStart.getHour());
                        startDate = startDate.plusMinutes(oneStart.getMinute());
                        endDate = endDate.plusHours(oneEnd.getHour());
                        endDate = endDate.plusMinutes(oneEnd.getMinute());
                        break;
                    case "3-4":
                        startDate = startDate.plusHours(twoStart.getHour());
                        startDate = startDate.plusMinutes(twoStart.getMinute());
                        endDate = endDate.plusHours(twoEnd.getHour());
                        endDate = endDate.plusMinutes(twoEnd.getMinute());
                        break;
                    case "5-6":
                        startDate = startDate.plusHours(threeStart.getHour());
                        startDate = startDate.plusMinutes(threeStart.getMinute());
                        endDate = endDate.plusHours(threeEnd.getHour());
                        endDate = endDate.plusMinutes(threeEnd.getMinute());
                        break;
                    case "7-8":
                        startDate = startDate.plusHours(fourStart.getHour());
                        startDate = startDate.plusMinutes(fourStart.getMinute());
                        endDate = endDate.plusHours(fourEnd.getHour());
                        endDate = endDate.plusMinutes(fourEnd.getMinute());
                        break;
                    case "9-10":
                        startDate = startDate.plusHours(fiveStart.getHour());
                        startDate = startDate.plusMinutes(fiveStart.getMinute());
                        endDate = endDate.plusHours(fiveEnd.getHour());
                        endDate = endDate.plusMinutes(fiveEnd.getMinute());
                        break;
                }

                // 创建事件
                String eventName = kbItem.getString("kcmc")+" at "+kbItem.getString("cdmc");
                DateTime start = new DateTime(java.util.Date.from(startDate.atZone(zoneId).toInstant()).getTime());
                DateTime end = new DateTime(java.util.Date.from(endDate.atZone(zoneId).toInstant()).getTime());
                VEvent meeting = new VEvent(start, end, eventName);

                //添加地点
                meeting.getProperties().add(new Location(kbItem.getString("cdmc")));

                // 添加时区信息/outlook不支持从这里读时区，google日历支持
//                meeting.getProperties().add(tz.getTimeZoneId());

                // 重复事件
                Integer xqj = kbItem.getInt("xqj");
                Recur recur = new Recur(Recur.WEEKLY, lastWeekWithLesson-firstWeekWithLesson+1);
                switch (xqj) {
                    case 1:
                        recur.getDayList().add(WeekDay.MO);
                        break;
                    case 2:
                        recur.getDayList().add(WeekDay.TU);
                        break;
                    case 3:
                        recur.getDayList().add(WeekDay.WE);
                        break;
                    case 4:
                        recur.getDayList().add(WeekDay.TH);
                        break;
                    case 5:
                        recur.getDayList().add(WeekDay.FR);
                        break;
                    case 6:
                        recur.getDayList().add(WeekDay.SA);
                        break;
                    case 7:
                        recur.getDayList().add(WeekDay.SU);
                        break;
                }

                RRule rule = new RRule(recur);
                meeting.getProperties().add(rule);


                // 提醒,提前15分钟
                VAlarm valarm = new VAlarm(new Dur(0, 0, -15, 0));
                valarm.getProperties().add(new Summary("课程提醒"));
                valarm.getProperties().add(Action.DISPLAY);
                valarm.getProperties().add(new Description(kbItem.getString("kcmc")));
                // 将VAlarm加入VEvent
                meeting.getAlarms().add(valarm);

                // 生成唯一标志符
                UidGenerator ug = new UidGenerator("iCal4j");
                Uid uid = ug.generateUid();
                meeting.getProperties().add(uid);


                // 添加事件
                icsCalendar.getComponents().add(meeting);
            }
        }

        FileOutputStream fout = new FileOutputStream(out);
        CalendarOutputter outputter = new CalendarOutputter();
        outputter.output(icsCalendar, fout);

    }
}
