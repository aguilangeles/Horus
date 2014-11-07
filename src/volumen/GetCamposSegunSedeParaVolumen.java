/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package volumen;

import entidades.Volumen;
import sedes.GetCamposGNA;
import sedes.GetCamposOSN;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class GetCamposSegunSedeParaVolumen {

  private String campos;

  public GetCamposSegunSedeParaVolumen(Volumen volumen) {
    discriminarContenidodelVolumen(volumen);
  }

  private void discriminarContenidodelVolumen(Volumen volumen) {
    switch (volumen.getSigla())
      {
      case "GNA":
        GetCamposGNA gna =
                new GetCamposGNA(" where i.idVolumen = " + volumen.getId() + " ;");
        campos = gna.toString();
        break;
      case "OSN":
        GetCamposOSN osn2 =
                new GetCamposOSN("where i.idVolumen = " + volumen.getId() + " ;");
        campos = osn2.toString();
        break;
      }

  }

  public String getCampos() {
    return campos;
  }
}
