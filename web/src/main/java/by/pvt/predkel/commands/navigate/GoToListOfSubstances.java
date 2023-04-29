package by.pvt.predkel.commands.navigate;

import by.pvt.predkel.commands.AbstractCommand;
import by.pvt.predkel.entities.FlammableSubstance;
import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.logger.MyLogger;
import by.pvt.predkel.parameters.Attributes;
import by.pvt.predkel.parameters.Errors;
import by.pvt.predkel.parameters.Parameters;
import by.pvt.predkel.parameters.Path;
import by.pvt.predkel.serviceForDao.IFlammableSubstanceService;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class GoToListOfSubstances extends AbstractCommand {

    public String execute(HttpServletRequest request, IFlammableSubstanceService flammableSubstanceService) {
        Integer page;
        try {
            page = Integer.valueOf(request.getParameter(Parameters.PAGE));//если заходим в первый раз
        } catch (NumberFormatException e) {// то выкинет null и попадем на первую
            page = 1;//а если просто переходим на след. страницу
        }//достанем из параметров номер страницы
        Integer maxResult;
        if (request.getSession().getAttribute(Attributes.PAGINATION_SIZE) != null) {
            maxResult = (Integer) request.getSession().getAttribute(Attributes.PAGINATION_SIZE);
        } else maxResult = 10;

        Integer countOfPages = 0;
        List<FlammableSubstance> substances = null;
        try {
            Long countOfSubstances = flammableSubstanceService.getCountOfSubstances();
            countOfPages = (int) Math.ceil((double) countOfSubstances / maxResult);
            substances = flammableSubstanceService.getSubstancesForPage(page, maxResult);
        } catch (DaoException e) {
            MyLogger.INSTANCE.logError(getClass(), e.getMessage());
            request.setAttribute(Attributes.ERROR, Errors.DB_ERROR);
        }
        List<FlammableSubstance> leftSubstances = new ArrayList<FlammableSubstance>();//материалы, коорые будут в левом столбце
        List<FlammableSubstance> rightSubstances = new ArrayList<FlammableSubstance>();//материалы, коорые будут в правом столбце
        Integer size = 0;//количество всех материалов, выбрасываемых на страницу, и один новый
        //нужно для обработке полей при редактировании
        if (substances != null) {
            int firstHalf = new BigDecimal(substances.size() / 2).setScale(0, RoundingMode.UP).intValue();
            for (int i = 0; i < firstHalf; i++) leftSubstances.add(substances.get(i));
            for (int i = firstHalf; i < substances.size(); i++) rightSubstances.add(substances.get(i));
            size = substances.size() + 1;
        }
        if (countOfPages == 0) countOfPages++;//если материалов вообще нет, надо вывести хотя бы одну страницу

        int difference = 3;
        int firstPage = 1;

        Boolean showFirstPage = false;
        Boolean showLastPage = false;
        Boolean showFirstDots = false;
        Boolean showLastDots = false;


        if (page > difference + firstPage + 1) {//если первая цифра слева не достает до первой
            showFirstDots = true;
        }
        if (page + difference + 1 < countOfPages) {//если последняя цифра справа не достает до последней
            showLastDots = true;
        }

        List<Integer> beforeThisPage = new ArrayList<Integer>();
        if (page > difference + firstPage) {
            for (int i = page - difference; i < page; i++)
                beforeThisPage.add(i);
            showFirstPage = true;
        } else if ((page <= difference + firstPage) && (page > firstPage)) {
            for (int i = 1; i < page; i++) {
                beforeThisPage.add(i);
            }
        }

        List<Integer> afterThisPage = new ArrayList<Integer>();
        if (page + difference < countOfPages) {
            for (int i = page + 1; i <= page + difference; i++)
                afterThisPage.add(i);
            showLastPage = true;
        } else if (page >= countOfPages - difference) {
            for (int i = page + 1; i <= countOfPages; i++)
                afterThisPage.add(i);
        }

        int previousPage = 0;
        if (page > firstPage) {
            previousPage = page - 1;
        }

        int nextPage = 0;
        if (page < countOfPages) {
            nextPage = page + 1;
        }

        request.setAttribute(Attributes.SHOW_FIRST_DOTS, showFirstDots);
        request.setAttribute(Attributes.SHOW_LAST_DOTS, showLastDots);
        request.setAttribute(Attributes.SHOW_FIRST_PAGE, showFirstPage);
        request.setAttribute(Attributes.SHOW_LAST_PAGE, showLastPage);
        request.setAttribute(Attributes.NUMBERS_BEFORE_THIS_PAGE, beforeThisPage);
        request.setAttribute(Attributes.NUMBERS_AFTER_THIS_PAGE, afterThisPage);
        request.setAttribute(Attributes.NUMBER_OF_PREVIOUS_PAGE, previousPage);
        request.setAttribute(Attributes.NUMBER_OF_NEXT_PAGE, nextPage);

        request.setAttribute(Attributes.LEFT_SUBSTANCES, leftSubstances);
        request.setAttribute(Attributes.RIGHT_SUBSTANCES, rightSubstances);
        request.setAttribute(Attributes.COUNT_OF_PAGES, countOfPages);
        request.setAttribute(Attributes.AMOUNT_OF_SUBSTANCES, size);
        request.setAttribute(Attributes.PAGE, page);
        return Path.SUBSTANCES_PATH;
    }
}
