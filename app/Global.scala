/**
 * Created by madamowski on 04/03/2014.
 */

import play.api._

object Global extends GlobalSettings {

  override def onStart(app: Application) {
    Logger.info("Application has started")
    //UserDatabase.init
  }

  override def onStop(app: Application) {
    Logger.info("Application shutdown...")
  }

}
