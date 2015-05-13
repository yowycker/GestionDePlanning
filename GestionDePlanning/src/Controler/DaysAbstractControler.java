package Controler;

import java.util.ArrayList;

import Model.DaysAbstractModel;
import Model.CalendarObject.Calendar;
import Model.CalendarObject.Formation;

public abstract class DaysAbstractControler {
	  protected DaysAbstractModel daysModel;
	  protected int index = 0;
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
	   * @param holiday
	   * @param saturday
	   * @param sunday
	   */
	  public abstract void newCalendar(String Years, boolean holiday, boolean saturday, boolean sunday);

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
	  public abstract void addFormation(String title, double nbHoursSeances);

	  /**
	   * Méthode de modification d'une formation
	   * @param title
	   * @param nbHoursSeances
	   */
	  public abstract void modifyFormation(String title, String newtitle, double newNbHoursSeances);


	  /**
	   * Méthode de suppression d'une formation
	   * @param title
	   * @param nbHoursSeances
	   */
	  public abstract void deleteFormation(String title, double nbHoursSeances);
	  
	  /**
	   * Méthode d'initialisation de l'affichage
	   */
	  public abstract void initFormation();

	  /**
	   * Méthode d'initialisation de l'affichage lors d'une selection
	   */
	  public abstract void selectFormation(Formation formation);
	  
// recup de listes
	  /**
	   * Ascesseur retournant la liste des années
	   * @return
	   */
	  public abstract ArrayList<String> getListYears();
}
