package Controler;

import java.awt.Color;
import java.util.ArrayList;

import Model.DaysAbstractModel;
import Model.CalendarObject.Calendar;
import Model.CalendarObject.Day;
import Model.CalendarObject.Formation;
import Model.CalendarObject.Module;
import Model.CalendarObject.Teacher;

public abstract class DaysAbstractControler {
	  protected DaysAbstractModel daysModel;
	  protected int index = 0;
	  protected int indexMonthMenu = 0;
	  protected boolean isInit = false;
	  
	  protected final int nbYearsList = 7;
	  
	  /**
	   * Constructeur de la classe DaysAbstractControler
	   * Affichage calendrier
	   * @param daysModel
	   */
	  public DaysAbstractControler(DaysAbstractModel daysModel){
	    this.daysModel = daysModel;
	  }
	  
	  /**
	   * Méthode semaine suivante
	   */
	  public abstract void nextWeek();
	  
	  /**
	   * Méthode semaine précédente
	   */
	  public abstract void afterWeek();
	  
	  /**
	   * Méthode Nouveau Calendar
	   * @param Years
	   * @param Formation
	   * @param saturday
	   * @param sunday
	   */
	  public abstract void newCalendar(String years, String titreFormation, String formationHSeances, boolean saturday, boolean sunday);

	  /**
	   * Méthode d'initialisation des données
	   * @param c
	   */
	  public abstract void initData(Calendar c);
	  
	  
// Affichage Menus
	  /**
	   * Méthode de création d'une nouvelle formation
	   * @param title
	   * @param nbHoursSeances
	   */
	  public abstract void addFormation(String title, String nbHoursSeances);

	  /**
	   * Méthode de modification d'une formation
	   * @param title
	   * @param nbHoursSeances
	   */
	  public abstract void modifyFormation(String title, String newtitle, String newNbHoursSeances);


	  /**
	   * Méthode de suppression d'une formation
	   * @param title
	   * @param nbHoursSeances
	   */
	  public abstract void deleteFormation(String title);
	  
	  /**
	   * Méthode d'initialisation de l'affichage des formations
	   */
	  public abstract void initFormation();
	  
// recup de listes
	  /**
	   * Ascesseur retournant la liste des années
	   * @return
	   */
	  public abstract ArrayList<String> getListYears();

	  /**
	   * Méthode d'initialisation de l'affichage des modules
	   */
	  public abstract void initModules(boolean initSeances);
	  /**
	   * Méthode d'initialisation de l'affichage des modules lors d'un selection
	   */
	  public abstract void selectModule(String nameModule, boolean initSeances);
	  /**
	   * Méthode permettant d'ajouter un module et de mettre a jour l'affichage
	   */
	  public abstract void addModule(String newName, String newAbbreviation, String newMaxSeances, Color newColor);
	  /**
	   * Méthode permettant de modifier un module et de mettre a jour l'affichage
	   */
	  public abstract void modifyModule(String nameModule, String newName, String newAbbreviation, String newMaxSeances, Color newColor);
	  /**
	   * Méthode permettant de supprimer un module et de mettre a jour l'affichage
	   */
	  public abstract void removeModule(String nameModule);
	  
	  
	  public abstract void initDaysMonth();
	  public abstract void getDaysMonth();
	  public abstract void afterDaysMonth();
	  public abstract void nextDaysMonth();
	  public abstract void modifyHoliday(boolean holiday, Day day);
	  
	  public abstract void addTeacher(String name, String firstname, String abbreviation, String email, String phone);
	  public abstract void modifyTeacher(String oldEmail, String name, String firstname, String abbreviation, String email, String phone);
	  public abstract void removeTeacher(String email);
	  public abstract void initTeacher(boolean inCalendar, boolean initSeances);
	  public abstract void selectTeacher(String email,boolean inCalendar, boolean initSeances);
	  
	  public abstract void removeSeance(Module module, Day day, int position);
	  public abstract void addSeances(Module module, String emailTeacher, Day day, int position);
	  
	  
	  public abstract void selectFormation(String title);
	  
	  public abstract void serializeCalendar();
}
