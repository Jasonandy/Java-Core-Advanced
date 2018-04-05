package cn.ucaner.core.thread.daemon;

import java.util.Date;

/**
* @Package：cn.ucaner.core.thread.daemon   
* @ClassName：Event   
* @Description：   <p> 事件类</p>
* @Author： - bysocket   
* @CreatTime：2018年4月5日 下午1:22:19   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class Event {
    private Date date;
    private String event;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
