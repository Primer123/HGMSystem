package action;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import service.RoomService;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
    }
    
    

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		//在Servlet中获取配置文件
		ServletContext sctx = this.getServletContext();
		ApplicationContext actx = WebApplicationContextUtils.getWebApplicationContext(sctx);
		RoomService roomService = (RoomService) actx.getBean("RoomService");
		
		//初始化一个ScheduledExecutorService对象，其中线程池为1
		ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        //定义需要执行的业务功能
        Runnable task1 = new Runnable()
        {
             public void run()
             {
            	 roomService.autoSetRoomState();
             }
        };
        
        /*
         * 调用ScheduledExecutorService对象来执行任务
         * 该方法需要四个参数
         * 第一个参数表示当时间到达时要执行的任务
         * 第二个参数表示首次执行的延迟时间
         * 第三个参数表示执行任务的周期
         * 第四个参数表示第二个和第三个参数的单位
         */
        DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");  
        DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");  
        Date currentDate;
		try {
			currentDate = dateFormat.parse(dayFormat.format(new Date()) + " " + "00:01:00");
			long oneDay = 24 * 60 * 60;
	        long initDelay = (currentDate.getTime() - System.currentTimeMillis()) / 1000;
	        
	        initDelay = initDelay > 0 ? initDelay : oneDay + initDelay; 
	        
	        final ScheduledFuture future1 = service.scheduleAtFixedRate(task1,initDelay,oneDay,TimeUnit.SECONDS);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	/**
     * @see HttpServlet#HttpServlet()
     */
    public TimerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
