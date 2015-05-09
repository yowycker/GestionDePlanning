package Controler;

import java.util.ArrayList;

import Model.DaysAbstractModel;
import Model.CalendarObject.Calendar;

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
	  public abstract void newFormations(String title, double nbHoursSeances);
	  
	  /**
	   * M�thode d'initialisation des formations
	   */
	  public abstract void initFormations();
	  
// recup de listes
	  /**
	   * Ascesseur retournant la liste des ann�es
	   * @return
	   */
	  public abstract ArrayList<String> getListYears();
}
