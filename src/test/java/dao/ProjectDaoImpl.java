package dao;

import enums.ProjectType;
import models.Project;
import services.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectDaoImpl implements ProjectDao{

    static Connection con = DataBaseConnection.getConnection();

    @Override
    public int add(Project project) throws SQLException {
        String query = "insert into project (name,announcement,show_announcement,type) values (?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, project.getName());
        ps.setString(2, project.getAnnouncement());
        ps.setBoolean(3, project.isShowAnnouncement());
        ps.setInt(4,project.getType());

        return ps.executeUpdate();
    }

    @Override
    public Project getProject(int id) throws SQLException {
        String query = "select * from project where id = ?";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();

        boolean check = false;
        Project project = Project.builder().build();

        while (rs.next()){
            check = true;
            project.setId(rs.getInt("id"));
            project.setName(rs.getString("name"));
            project.setAnnouncement(rs.getString("announcement"));
            project.setShowAnnouncement(rs.getBoolean("show_announcement"));
            project.setType(rs.getInt("type"));
        }

       return check ? project : null;
    }

    @Override
    public int deleteProject(int id) throws SQLException {

        String query = "delete from project where id = ?";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,id);

        return ps.executeUpdate();
    }

    @Override
    public int updateProject(Project project) throws SQLException {

        String query = "update project set name = ?, announcement = ?, show_announcement = ?, type = ? where id = ?";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, project.getName());
        ps.setString(2, project.getAnnouncement());
        ps.setBoolean(3, project.isShowAnnouncement());
        ps.setInt(4,project.getType());
        ps.setInt(5, project.getId());

        return ps.executeUpdate();
    }

    @Override
    public List<Project> getProjects() throws SQLException {
        String query = "select * from project";

        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        List<Project> projectList = new ArrayList<>();

        while (rs.next()){
            Project project = Project.builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .announcement(rs.getString("announcement"))
                    .isShowAnnouncement(rs.getBoolean("show_announcement"))
                    .type(rs.getInt("type"))
                    .build();
            projectList.add(project);
        }

        return projectList;
    }

    @Override
    public void drop() throws SQLException {
        String query = "drop table if exists project cascade;";

        PreparedStatement ps = con.prepareStatement(query);
        ps.execute();
    }

    @Override
    public void create() throws SQLException {

        String query = "create table project\n" +
                "(\n" +
                "    id                serial not null\n" +
                "        constraint project_pk\n" +
                "            primary key,\n" +
                "    name              varchar,\n" +
                "    announcement      varchar,\n" +
                "    show_announcement boolean,\n" +
                "    type              integer\n" +
                ");\n" +
                "\n" +
                "alter table project\n" +
                "    owner to postgres;\n" +
                "\n" +
                "create unique index project_id_uindex\n" +
                "    on project (id);";

        PreparedStatement ps = con.prepareStatement(query);
        ps.execute();
    }

    @Override
    public Project getProject(String name) throws SQLException {
        String query = "select * from project where name = ?";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,name);
        ResultSet rs = ps.executeQuery();

        boolean check = false;
        Project project = Project.builder().build();

        while (rs.next()){
            check = true;
            project.setId(rs.getInt("id"));
            project.setName(rs.getString("name"));
            project.setAnnouncement(rs.getString("announcement"));
            project.setShowAnnouncement(rs.getBoolean("show_announcement"));
            project.setType(rs.getInt("type"));
        }

        return check ? project : null;
    }
}
