/**
 * 
 */
package com.employee.satisfaction.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.satisfaction.dto.EmployeeRegister;
import com.employee.satisfaction.dto.QstnAnswDto;
import com.employee.satisfaction.dto.QstnInput;
import com.employee.satisfaction.dto.UserOutputDTO;
import com.employee.satisfaction.entities.QuestinsEntity;
import com.employee.satisfaction.entities.QuestionsAnsw;
import com.employee.satisfaction.entities.RolesEntity;
import com.employee.satisfaction.entities.UsersEntity;
import com.employee.satisfaction.repo.QuestAnswRepo;
import com.employee.satisfaction.repo.QuestionRepo;
import com.employee.satisfaction.repo.RolesRepo;
import com.employee.satisfaction.repo.UserRepo;
import com.employee.satisfaction.service.SatisfactionService;

/**
 * @author kvenkateswara
 *
 */
@Service
public class SatisfactionServiceImpl implements SatisfactionService {

	@Autowired
	QuestAnswRepo objQuestAnswRepo;

	@Autowired
	QuestionRepo objQuestionRepo;

	@Autowired
	RolesRepo objRolesRepo;

	@Autowired
	UserRepo objUserRepo;

	@Override
	public void intializeDefaultValues() {
		// TODO Auto-generated method stub
		RolesEntity entity = new RolesEntity();
		entity.setCreatedBy(1);
		entity.setCreatedDate(new Date());
		entity.setDescrption("Admin");
		entity.setIsactive(1);
		entity.setRolename("Admin");

		objRolesRepo.save(entity);

		RolesEntity entity1 = new RolesEntity();
		entity1.setCreatedBy(1);
		entity1.setCreatedDate(new Date());
		entity1.setIsactive(1);
		entity1.setDescrption("Employee");
		entity1.setRolename("Employee");

		objRolesRepo.save(entity1);

		UsersEntity usersEntity = new UsersEntity();
		usersEntity.setCreatedBy(1);
		usersEntity.setEmail("admin@email.com");
		usersEntity.setCreatedDate(new Date());
		usersEntity.setFname("Test");
		usersEntity.setLname("admin");
		usersEntity.setIsactive(1);
		usersEntity.setPassword("123456");
		usersEntity.setPhonenumber("9010322260");
		usersEntity.setRoleid(1);
		usersEntity.setUname("admin");

		objUserRepo.save(usersEntity);

		UsersEntity usersEntity1 = new UsersEntity();
		usersEntity1.setCreatedBy(1);
		usersEntity1.setEmail("admin@email.com");
		usersEntity1.setCreatedDate(new Date());
		usersEntity1.setFname("Test");
		usersEntity1.setLname("Employee");
		usersEntity1.setIsactive(1);
		usersEntity1.setPassword("123456");
		usersEntity1.setPhonenumber("9010322260");
		usersEntity1.setRoleid(2);
		usersEntity1.setUname("employee");

		objUserRepo.save(usersEntity1);

		QuestinsEntity question1 = new QuestinsEntity();
		question1.setCreatedBy(1);
		question1.setCreatedDate(new Date());
		question1.setDescrption("How meaningful is your work?");
		question1.setIsactive(1);
		question1.setQuestion("How meaningful is your work?");

		objQuestionRepo.save(question1);

		QuestinsEntity question2 = new QuestinsEntity();
		question2.setCreatedBy(1);
		question2.setCreatedDate(new Date());
		question2.setDescrption("How challenging is your work?");
		question2.setIsactive(1);
		question2.setQuestion("How challenging is your work?");

		objQuestionRepo.save(question2);

		QuestinsEntity question3 = new QuestinsEntity();
		question3.setCreatedBy(1);
		question3.setCreatedDate(new Date());
		question3.setDescrption("In a typical week, how often do you feel stressed at work?");
		question3.setIsactive(1);
		question3.setQuestion("In a typical week, how often do you feel stressed at work?");

		objQuestionRepo.save(question3);

		QuestinsEntity question4 = new QuestinsEntity();
		question4.setCreatedBy(1);
		question4.setCreatedDate(new Date());
		question4.setDescrption("How well are you paid for the work you do?");
		question4.setIsactive(1);
		question4.setQuestion("How well are you paid for the work you do?");

		objQuestionRepo.save(question4);

		QuestinsEntity question5 = new QuestinsEntity();
		question5.setCreatedBy(1);
		question5.setCreatedDate(new Date());
		question5.setDescrption("How much do your opinions about work matter to your coworkers?");
		question5.setIsactive(1);
		question5.setQuestion("How much do your opinions about work matter to your coworkers?");

		objQuestionRepo.save(question5);

//		QuestinsEntity question6=new QuestinsEntity();
//		question6.setCreatedBy(1);
//		question6.setCreatedDate(new Date());
//		question6.setDescrption("How challenging is your work?");
//		question6.setIsactive(1);
//		question6.setQuestion("How challenging is your work?");
//		
//		objQuestionRepo.save(question6);
	}

	@Override
	public UserOutputDTO getUser(String username, String password) {
		// TODO Auto-generated method stub
		UserOutputDTO objUserOutputDTO = new UserOutputDTO();
		Optional<UsersEntity> users = objUserRepo.findByUsername(username, password);
		if (users.isPresent()) {
			BeanUtils.copyProperties(users.get(), objUserOutputDTO);
		}
		return objUserOutputDTO;
	}

	@Override
	public UsersEntity register(EmployeeRegister login) {
		// TODO Auto-generated method stub
		UsersEntity usersEntity1 = new UsersEntity();
		usersEntity1.setCreatedBy(1);
		usersEntity1.setEmail(login.getEmail());
		usersEntity1.setCreatedDate(new Date());
		usersEntity1.setFname(login.getFname());
		usersEntity1.setLname(login.getLname());
		usersEntity1.setIsactive(1);
		usersEntity1.setPassword(login.getPasword());
		usersEntity1.setPhonenumber(login.getPasword());
		usersEntity1.setRoleid(2);
		usersEntity1.setUname(login.getUsername());

		return objUserRepo.save(usersEntity1);
	}

	@Override
	public QuestinsEntity addQuestion(QstnInput login) {
		// TODO Auto-generated method stub
		QuestinsEntity question3 = new QuestinsEntity();
		question3.setCreatedBy(login.getCreatedBy());
		question3.setCreatedDate(new Date());
		question3.setDescrption(login.getDesc());
		question3.setIsactive(1);
		question3.setQuestion(login.getQstn());

		return objQuestionRepo.save(question3);
	}

	@Override
	public QuestionsAnsw insertRating(QstnAnswDto login) {
		// TODO Auto-generated method stub
		QuestionsAnsw objQuestionsAnsw = new QuestionsAnsw();
		objQuestionsAnsw.setComments(login.getComments());
		objQuestionsAnsw.setRating(login.getRating());
		objQuestionsAnsw.setIsactive(1);
		objQuestionsAnsw.setEmpId(login.getEmpId());
		objQuestionsAnsw.setQuestion_id(login.getQId());
		objQuestionsAnsw.setCreatedBy(login.getCreatedBy());
		objQuestionsAnsw.setCreatedDate(new Date());

		return objQuestAnswRepo.save(objQuestionsAnsw);
	}

	@Override
	public Object getEmployees() {
		// TODO Auto-generated method stub
		return objUserRepo.findAll();
	}

	@Override
	public Object getSatisfactoryReport() {
		// TODO Auto-generated method stub
		List<QuestionsAnsw> lstAllData=objQuestAnswRepo.findAll();
		Map<Integer, List<QuestionsAnsw>> empwiseReport=lstAllData.stream().collect(Collectors.groupingBy(QuestionsAnsw::getEmpId,Collectors.toList()));		
		
		return empwiseReport;
	}

	@Override
	public Object getQstn() {
		// TODO Auto-generated method stub
		return objQuestionRepo.findAll();
	}

}
