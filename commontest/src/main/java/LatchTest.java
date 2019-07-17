import com.alibaba.fastjson.JSON;
import com.wxb.commontest.BanZhuRenParam;
import lombok.Data;

import java.util.concurrent.CountDownLatch;

public class LatchTest {

    public static void main(String[] args) throws InterruptedException {
        Runnable taskTemp = new Runnable() {

            // 注意，此处是非线程安全的，留坑
            private int iCounter;

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    // 发起请求
                    String result = HttpClientUtils.doPostJson("http://localhost:8089/crm-manager-master/sys/fenxiao/insertYaoYue?token=c590b2653d28124dc30930f0b37fed83"
                            , JSON.toJSONString(new param() {{
                                setCustomerName("张张张");
                                setSex(1);
                                setExamId(5);
                                setMendianId(1);
                                setAppointmentTimeStart("2019-06-08 10:10:10");
                                setAppointmentTimeEnd("2019-06-08 10:10:10");
                                setAppointmentRemark("测试一");
                                setMobile("1560138616577");
                            }}));
                    System.out.println(result);
                    iCounter++;
                    System.out.println(System.nanoTime() + " [" + Thread.currentThread().getName() + "] iCounter = " + iCounter);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        LatchTest latchTest = new LatchTest();
        latchTest.startTaskAllInOnce(10, taskTemp);
    }

    public long startTaskAllInOnce(int threadNums, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(threadNums);
        for (int i = 0; i < threadNums; i++) {
            Thread t = new Thread() {
                public void run() {
                    try {
                        // 使线程在此等待，当开始门打开时，一起涌入门中
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            // 将结束门减1，减到0时，就可以开启结束门了
                            endGate.countDown();
                        }
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            };
            t.start();
        }
        long startTime = System.nanoTime();
        // 因开启门只需一个开关，所以立马就开启开始门
        startGate.countDown();
        // 等等结束门开启
        endGate.await();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

}

@Data
class param {
    private String customerName;
    private Integer sex;
    private Integer examId;
    private Integer mendianId;
    private String appointmentTimeStart;
    private String appointmentTimeEnd;
    private String appointmentRemark;
    private String mobile;
}