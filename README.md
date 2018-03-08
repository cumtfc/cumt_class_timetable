# cumt_class_timetable
根据JSON生成课程表ics文件，用于各日历平台导入。
# usage
因为教务系统登陆有加密,所以暂不支持直接输学号密码导出
主函数里的`cookie`替换为自己从教务系统登陆后得到的sessionID，运行程序即可生成kcb.ics文件，再手动导入到需要的日历即可。
outlook导入说明https://support.office.com/zh-cn/article/%E5%9C%A8-outlook-com-%E4%B8%AD%E5%AF%BC%E5%85%A5%E6%88%96%E8%AE%A2%E9%98%85%E6%97%A5%E5%8E%86-cff1429c-5af6-41ec-a5b4-74f2c278e98c
