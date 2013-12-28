/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nzo;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author nayzo
 */

@WebService
public class webservice {


    public void webservice() {
    }

    @WebMethod
    public String wsuploadvideo (Integer iduer, String name) {
        RestVideo video = new RestVideo();
            video.wsVideo(iduer, name);
        return "ok";
    }
}