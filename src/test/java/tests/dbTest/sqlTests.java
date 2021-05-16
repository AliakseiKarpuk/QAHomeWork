package tests.dbTest;

import dao.ProjectDaoImpl;
import enums.ProjectType;
import lombok.SneakyThrows;
import models.Project;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import services.JdbcService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class sqlTests {
    Logger logger = LogManager.getLogger();

    //@Test
    public void connectionTest() throws SQLException {
        JdbcService jdbcService = new JdbcService();
        ResultSet resultSet = jdbcService.executeQuery("select * from customers;");

        while (resultSet.next()){
            String id = resultSet.getString("id");
            String firstname = resultSet.getString("firstname");
            String lastname = resultSet.getString(3);
            String email = resultSet.getString("email");
            int age = resultSet.getInt("age");

            logger.info("result : id = " + id + " firstname = " + firstname + " lastname = " + lastname + " email = " + email + " age = " + age);
        }

        jdbcService.closeConnection();
    }

    @SneakyThrows
    @Test
    public void getProjectTest(){
        ProjectDaoImpl prDao = new ProjectDaoImpl();

        Project project = prDao.getProject(3);
        System.out.println(project.toString());
    }

    @SneakyThrows
    @Test
    public void addProjectTest(){
        ProjectDaoImpl prDao = new ProjectDaoImpl();
        Project project = Project.builder()
                .name("PR05")
                .announcement("PR05 Announ")
                .isShowAnnouncement(true)
                .type(ProjectType.MULTIPLE)
                .build();

        System.out.println(prDao.add(project));
    }

    @SneakyThrows
    @Test
    public void updateProjectTest(){
        ProjectDaoImpl prDao = new ProjectDaoImpl();
        Project project = Project.builder()
                .id(4)
                .name("PR05 UPD")
                .announcement("PR05 Announ UPD")
                .isShowAnnouncement(false)
                .type(ProjectType.SINGLE_FOR_ALL_CASES)
                .build();

        System.out.println(prDao.updateProject(project));
    }

    @SneakyThrows
    @Test
    public void getAllProjectsTest(){
        ProjectDaoImpl prDao = new ProjectDaoImpl();

       for(Project pr : prDao.getProjects()){
           System.out.println(pr.toString());
       }
    }

    @SneakyThrows
    @Test
    public void deleteProjectTest(){
        ProjectDaoImpl prDao = new ProjectDaoImpl();

        System.out.println(prDao.deleteProject(3));
    }
}
