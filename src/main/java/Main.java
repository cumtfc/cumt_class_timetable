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

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
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

        //http请求
        String cookie = "JSESSIONID=4C5AE92F5DBC2B2293A7F6967A346465";

        String kcbJson = Main.sendPost("http://202.119.206.62/jwglxt/kbcx/xskbcx_cxXsKb.html","xnm=2017&xqm=4",cookie);


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
                Recur recur = new Recur(Recur.WEEKLY, lastWeekWithLesson - firstWeekWithLesson + 1);
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


                // 提醒,提前10分钟
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


    public static String sendPost(String url, String paramStr,String cookie) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        url = url + "?" + paramStr;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("cookie", cookie);
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
//            out.print(paramStr);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
}
