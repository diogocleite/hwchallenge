package gist;

import httpinterfaces.GistInterface;
import objects.Content;
import objects.FileGist;
import objects.Gist;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.ResponseBody;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GistApiTest {

    private static GistInterface api;
    private static String DEFAULT_VALUE = "";
    private static String TOKEN = "";

    @BeforeClass
    public static void beginTest() throws IOException {
        Gson gson = new GsonBuilder()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        api = retrofit.create(GistInterface.class);

        TOKEN = "token " + System.getProperty("token", DEFAULT_VALUE);
    }

    @Test
    public void createGist() throws IOException {
        Content content = new Content("ola");
        Map<String,Content> files = new HashMap<String, Content>();

        files.put("Teste1.txt",content);
        FileGist fileGist = new FileGist("MeuTeste",true, files);

        //create gist
        Response<Gist> response = api.creatGist(TOKEN, fileGist).execute();

        //check if created
        Assert.assertEquals("201 Created",response.headers().get("Status"));

        String id = response.body().getId();

        //check if gist was created
        Response<Gist> responseList = api.listGist(TOKEN,id).execute();
        Assert.assertEquals("200 OK",responseList.headers().get("Status"));

    }

    @Test
    public void deleteGistTest() throws IOException {
        Boolean haveGist = false;

        //Create new file with gist structure
        Content mynewcont = new Content("creat to delete");
        Map<String,Content> newfiles = new HashMap();
        newfiles.put("filehwdelete.txt",mynewcont);
        FileGist filee = new FileGist("create test hw to delete",false, newfiles);

        //Create file on Objects.Gist
        Response<Gist> objcreated = api.creatGist(TOKEN,filee).execute();

        //Extract response body
        Gist jsonobjcreated = objcreated.body();

        //Get id to find if is in the list of files
        String idcreated = jsonobjcreated.getId();

        //Delete file that was created before
        Response<ResponseBody> objdel = api.deleteGist(TOKEN,idcreated).execute();

        //Confirm status code it was the expected
        Assert.assertEquals("204 No Content",objdel.headers().get("Status"));


        Response<Gist> responseList = api.listGist(TOKEN,idcreated).execute();

        Assert.assertNotEquals("200 OK",responseList.headers().get("Status"));



        //Get the list of my files
        List<Gist> mygistsafterdel = api.listUserGists(TOKEN).execute().body();



        //Check if delete file isn't in the list
        for(Gist thisgist : mygistsafterdel)
        {
            if(thisgist.getId().equals(idcreated)){
                haveGist = true;
            }
        }

        Assert.assertFalse(haveGist);

    }

    @Test
    public void checkFieldsGists() throws IOException {

        //Get User Gists
        Response<List<Gist>> objcreated = api.listUserGists(TOKEN).execute();
        List<Gist> mygistlist = objcreated.body();

        //checka all gists
        for(Gist thisgist : mygistlist)
        {
            Assert.assertNotNull(thisgist.getUrl());
            Assert.assertNotNull(thisgist.getForks_url());
            Assert.assertNotNull(thisgist.getCommits_url());
            Assert.assertNotNull(thisgist.getId());
            Assert.assertNotNull(thisgist.getNode_id());
            Assert.assertNotNull(thisgist.getGit_pull_url());
            Assert.assertNotNull(thisgist.getGit_push_url());
            Assert.assertNotNull(thisgist.getHtml_url());
            Assert.assertNotNull(thisgist.getFileGist());
            Assert.assertNotNull(thisgist.getPublicc());
            Assert.assertNotNull(thisgist.getCreated_at());
            Assert.assertNotNull(thisgist.getUpdated_at());
            Assert.assertNotNull(thisgist.getDescription());
            Assert.assertNotNull(thisgist.getComments());
            Assert.assertNotNull(thisgist.getComments_url());
            Assert.assertNotNull(thisgist.getOwner());
            Assert.assertNotNull(thisgist.getTruncated());

            //check all files
            Map<String, Content> listFiles = thisgist.getFileGist();
            for (Map.Entry<String, Content> entry : listFiles.entrySet()) {
                Assert.assertNotNull(entry.getKey());
                Assert.assertNotNull(entry.getValue().getFilename());
                Assert.assertNotNull(entry.getValue().getType());
                Assert.assertNotNull(entry.getValue().getLanguage());
                Assert.assertNotNull(entry.getValue().getRaw_url());
                Assert.assertNotNull(entry.getValue().getSize());
                Assert.assertNull(entry.getValue().getContent());
            }

            Assert.assertNotNull(thisgist.getOwner().getLogin());
            Assert.assertNotNull(thisgist.getOwner().getId());
            Assert.assertNotNull(thisgist.getOwner().getNode_id());
            Assert.assertNotNull(thisgist.getOwner().getAvatar_url());
            Assert.assertNotNull(thisgist.getOwner().getGravatar_id());
            Assert.assertNotNull(thisgist.getOwner().getUrl());
            Assert.assertNotNull(thisgist.getOwner().getHtml_url());
            Assert.assertNotNull(thisgist.getOwner().getFollowers_url());
            Assert.assertNotNull(thisgist.getOwner().getFollowing_url());
            Assert.assertNotNull(thisgist.getOwner().getGists_url());
            Assert.assertNotNull(thisgist.getOwner().getStarred_url());
            Assert.assertNotNull(thisgist.getOwner().getSubscriptions_url());
            Assert.assertNotNull(thisgist.getOwner().getOrganizations_url());
            Assert.assertNotNull(thisgist.getOwner().getRepos_url());
            Assert.assertNotNull(thisgist.getOwner().getEvents_url());
            Assert.assertNotNull(thisgist.getOwner().getReceived_events_url());
            Assert.assertNotNull(thisgist.getOwner().getType());
            Assert.assertNotNull(thisgist.getOwner().getSite_admin());


        }

    }

}
