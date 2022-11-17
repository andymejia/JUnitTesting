package projects.service;

import java.util.List;
import projects.dao.ProjectDao;
import projects.entity.Project;
import java.util.NoSuchElementException;


public class ProjectService {
  private ProjectDao projectDao = new ProjectDao();

  public Project addProject(Project project) {
    return projectDao.insertProject(project);
  }

  public List<Project> fetchAllProjects() {
    return projectDao.fetchAllProjects();
  }

  /**
   * 
   * @param projectId The project ID.
   * @return A Project object if successful.
   * @throws NoSuchElementException Thrown if the project with the given ID does not exist.
   */
  public Project fetchProjectById(Integer projectId) {
    return projectDao.fetchProjectById(projectId).orElseThrow(() -> new NoSuchElementException(
        "Project with project ID = " + projectId + " does not exist."));
  }

}