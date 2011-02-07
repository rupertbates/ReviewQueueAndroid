import android.os.AsyncTask

private class ReviewFetcherTask extends AsyncTask[Void, Int, Void] {
     def doInBackground() : Long = {
         while (true)
         {
             downloadReviews()
             publishProgress((int) ((i / (float) count) * 100));
             Thread.sleep(10000);
         }

     }
     def downloadReviews() = {


     }
     def onProgressUpdate() = {
         //setProgressPercent(progress[0]);
        //Update UI from db
     }

     def onPostExecute() = {
         //don't think we're ever going to need this unless there's some tidy up to do
     }
 }

