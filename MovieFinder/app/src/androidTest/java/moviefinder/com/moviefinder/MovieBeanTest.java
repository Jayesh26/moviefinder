package moviefinder.com.moviefinder;

import android.content.Context;
import android.test.InstrumentationTestCase;

import com.assignment.moviefinder.db.bean.MovieBean;
import com.assignment.moviefinder.db.utils.AADataManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author jayesh
 * @Since 30/7/16.
 */
public class MovieBeanTest extends InstrumentationTestCase {

    private Context mContext;
    private List<MovieBean> dummyNewsList;
    private MovieBean movieBean;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mContext = getInstrumentation().getTargetContext();
        //Get dummy data for movie bean
        dummyNewsList = getDummyNewsData();
        movieBean = getMovieBean();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        AADataManager.deleteAll(MovieBean.class);
    }

    /**
     * test AADataManager add functions
     *
     * @throws Exception
     */
    public void testAdd() throws Exception {
        //Add data
        AADataManager.add(movieBean);

        //Verify data saved into DB by GetAll
        List<MovieBean> movieBeans = AADataManager.getAll(MovieBean.class);

        //Verify returned result of list
        assertTrue("List return from DB must be non-NULL result", movieBeans.size() > 0);
    }

    /**
     * test AADataManager addAll functions
     *
     * @throws Exception
     */
    public void testAddAll() throws Exception {
        //Add all data into DB
        AADataManager.addAll(dummyNewsList);

        //Verify data saved into DB by GetAll
        List<MovieBean> movieBeans = AADataManager.getAll(MovieBean.class);

        //Verify returned result of list
        assertNotNull("List return from DB must be non-NULL result", movieBeans);
        assertTrue("list must contain at least 1 element", movieBeans.size() > 0);

    }

    /**
     * test AADataManager getAll functions
     *
     * @throws Exception
     */
    public void testGetAll() throws Exception {
        //Add data to DB
        AADataManager.addAll(dummyNewsList);

        //Get all data from DB
        List<MovieBean> movieBeans = AADataManager.getAll(MovieBean.class);

        //Verify returned result of list
        assertNotNull("List return from DB must be non-NULL result", movieBeans);
        assertTrue("list must contain atleast 1 element", movieBeans.size() > 0);

        // verify if the fetched model has same values that we inserted
        assertEquals("\"ID from fetched data must be same as dummy insertion\" ",
                dummyNewsList.get(0).getTitle(), movieBeans.get(0).getTitle());
    }

    /**
     * test AADataManager get functions with condition
     *
     * @throws Exception
     */
    public void testGetAllWithCondition() throws Exception {
        //Add data to DB
        AADataManager.addAll(dummyNewsList);

        //Get All data from DB with given condition
        String[] where = new String[]{"title=?"};
        String[] whereArgs = new String[]{"kabali"};

        List<MovieBean> movieBeanList = AADataManager.getAll(MovieBean.class, where, whereArgs);

        //Verify result
        assertNotNull("Data fetched from Db with given ID must be non_NULL", movieBeanList);
        assertTrue("List must contain atleast 1 element", movieBeanList.size() > 0);
    }

    /**
     * @throws Exception
     */
    public void testDeleteAll() throws Exception {
        //Add data to DB
        AADataManager.addAll(dummyNewsList);

        //Delete data
        AADataManager.deleteAll(MovieBean.class);

        //Get all data from DB
        List<MovieBean> movieBeansList = AADataManager.getAll(MovieBean.class);
        //Verify returned result of list
        assertTrue("list must contain atleast 1 element", movieBeansList.size() > -1);
    }

    /**
     * Get dummy data for movie model
     *
     * @return
     */
    public List<MovieBean> getDummyNewsData() {
        List<MovieBean> list = new ArrayList<MovieBean>();
        MovieBean movieBean;
        for (int i = 0; i < 10; i++) {
            movieBean = new MovieBean.Builder("kabali", "2016", "5", "dram", "20July2016", "ranjnikant's movie", "URL").
                    build();

            list.add(movieBean);
        }
        return list;
    }

    /**
     * get dummy data for movie model
     *
     * @return
     */
    public MovieBean getMovieBean() {
        MovieBean movieBean = new MovieBean.Builder("kabali", "2016", "5", "dram", "20July2016", "ranjnikant's movie", "URL").
                build();
        return movieBean;
    }
}
