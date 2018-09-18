package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class test03 {

	//,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
	//啊啊啊啊啊啊啊啊啊啊啊
	//部署流程
	@Test
	public void test01() {

		ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();

		processEngine.getRepositoryService().createDeployment().name("报销单审核流程").addClasspathResource("BizClaimVoucher.bpmn").addClasspathResource("BizClaimVoucher.png").deploy();
		System.out.println("aaaaaaa");
		System.out.println("aaaaaaa");
		System.out.println("aaaaaaa");
		System.out.println("aaaaaaa");
	}


	//启动流程
	@Test
	public void test02() {

		ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("inputuser", "李黑");
		processEngine.getRuntimeService().startProcessInstanceByKey("BizClaimVoucher",map);

	}


	//根据处理人查询相关的任务
	@Test
	public void test03() {

		ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();

		List<Task> list=processEngine.getTaskService().createTaskQuery().taskAssignee("李小小").list();
		for (Task task : list) {
			System.out.println("任务名称："+task.getName());
			System.out.println("任务ID："+task.getId());
			System.out.println("流程实例ID："+task.getProcessInstanceId());
		}


	}


	//员工发起报销单
	@Test
	public void test05() {

		ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("inputuser", "渣渣辉");
		map.put("role", "manager");


		processEngine.getTaskService().complete("7503",map);


	}

	//部门经理完成
	@Test
	public void test06() {

		ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("inputuser", "李小小");
		map.put("rollback", "no");


		processEngine.getTaskService().complete("10002",map);


	}





}
