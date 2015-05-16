package Controler;

import java.awt.Color;
import java.util.ArrayList;

import Model.DaysAbstractModel;
import Model.CalendarObject.Calendar;
import Model.CalendarObject.Day;
import Model.CalendarObject.Formation;
import Model.CalendarObject.Module;

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
	   * M�thode semaine suivante
	   */
	  public abstract void nextWeek();
	  
	  /**
	   * M�thode semaine pr�c�dente
	   */
	  public abstract void afterWeek();
	  
	  /**
	   * M�thode Nouveau Calendar
	   * @param Years
	   * @param holiday
	   * @param saturday
	   * @param sunday
	   */
	  public abstract void newCalendar(String Years, boolean holiday, boolean saturday, boolean sunday);

	  /**
	   * M�thode d'initialisation des donn�es
	   * @param c
	   */
	  public abstract void initData(Calendar c);
	  
	  
// Affichage Menus
	  /**
	   * M�thode de cr�ation d'une nouvelle formation
	   * @param title
	   * @param nbHoursSeances
	   */
	  public abstract void addFormation(String title, double nbHoursSeances);

	  /**
	   * M�thode de modification d'une formation
	   * @param title
	   * @param nbHoursSeances
	   */
	  public abstract void modifyFormation(String title, String newtitle, double newNbHoursSeances);


	  /**
	   * M�thode de suppression d'une formation
	   * @param title
	   * @param nbHoursSeances
	   */
	  public abstract void deleteFormation(String title, double nbHoursSeances);
	  
	  /**
	   * M�thode d'initialisation de l'affichage des formations
	   */
	  public abstract void initFormation();
	  
// recup de listes
	  /**
	   * Ascesseur retournant la liste des ann�es
	   * @return
	   */
	  public abstract ArrayList<String> getListYears();

	  /**
	   * M�thode d'initialisation de l'affichage des modules
	   */
	  public abstract void initModules();
	  /**
	   * M�thode d'initialisation de l'affichage des modules lors d'un selection
	   */
	  public abstract void selectModule(String nameModule);
	  /**
	   * M�thode permettant d'ajouter un module et de mettre a jour l'affichage
	   */
	  public abstract void addModule(String newName, String newAbbreviation, String newMaxSeances, Color newColor);
	  /**
	   * M�thode permettant de modifier un module et de mettre a jour l'affichage
	   */
	  public abstract void modifyModule(String nameModule, String newName, String newAbbreviation, String newMaxSeances, Color newColor);
	  /**
	   * M�thode permettant de supprimer un module et de mettre a jour l'affichage
	   */
	  public abstract void removeModule(String nameModule);
	  
	  
	  public abstract void initDaysMonth();
	  public abstract void afterDaysMonth();
	  public abstract void nextDaysMonth();
	  public abstract void modifyHoliday(boolean holiday, Day day);
}
