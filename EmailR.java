import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*;  
import java.util.StringTokenizer;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
 
/**
 * This program tests out the EmbeddedImageEmailUtil utility class.
 * @author www.codejava.net
 *
 */
public class EmailR
{
 
    /**
     * main entry of the program
     */
	
    public String send (String nom,String correo)
     {
	 	String respuesta;
        // SMTP info
        String host = "smtp.gmail.com";
        String port = "587";
        String mailFrom = "info@citipartum.com";
        String password = "tntdr8RW";
 
        // message info
        String mailTo = correo;
        String subject = "Bienvenid@ "+nom+" a PARTUM 2020";
        StringBuffer body = new StringBuffer("<html xmlns=http://www.w3.org/1999/xhtml xmlns:v=urn:schemas-microsoft-com:vml xmlns:o=urn:schemas-microsoft-com:office:office>");
        body.append("<head><meta content=text/html; charset=UTF-8 http-equiv=Content-Type /><!-- [ if !mso]> <!--><meta content=IE=edge http-equiv=X-UA-Compatible /><!-- <![endif] --><meta content=telephone=no name=format-detection /><meta content=width=device-width, initial-scale=1.0 name=viewport /><link rel=apple-touch-icon sizes=76x76 href=http://paulgoddarddesign.com/images/apple-icon.jpg><link rel=icon type=image/png sizes=96x96 href=http://paulgoddarddesign.com/images/favicon.jpg><title>Material Email Template</title><link href=https://fonts.googleapis.com/css?family=Roboto+Mono rel=stylesheet><script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script><script src=http://paulgoddarddesign.com/js/ripple.js></script><style type=text/css>");
        body.append("</style><!--[if gte mso 9]><xml><o:OfficeDocumentSettings><o:AllowPNG/><o:PixelsPerInch>96</o:PixelsPerInch></o:OfficeDocumentSettings></xml><![endif]--></head>");
        body.append("<body style=margin:0; padding:0; background-color: #eeeeee; bgcolor=#eeeeee>");
        body.append("<div id=fb-root></div><script async defer crossorigin=anonymous src=https://connect.facebook.net/es_ES/sdk.js#xfbml=1&version=v6.0></script><table width=100% cellpadding=0 cellspacing=0 border=0 bgcolor=#eeeeee>");
        body.append("<div class=Gmail style=height: 1px !important; margin-top: -1px !important; max-width: 600px !important; min-width: 600px !important; width: 600px !important;></div>");
        body.append("<div style=display: none; max-height: 0px; overflow: hidden;></div>");
        body.append("<div style=display: none; max-height: 0px; overflow: hidden;></div>");
        body.append("<tr><td width=100% valign=top align=center class=padding-container style=padding: 18px 0px 18px 0px!important; mso-padding-alt: 18px 0px 18px 0px;>");
        body.append("<table width=600 cellpadding=0 cellspacing=0 border=0 align=center class=wrapper><tr>");
        body.append("<td align=center><table cellpadding=0 cellspacing=0 border=0><tr><td width=100% valign=top align=center>");
        body.append("<table width=600 cellpadding=0 cellspacing=0 border=0 align=center class=wrapper bgcolor=#eeeeee><tr><td align=center>");
        //LOGO
        body.append("<table width=600 cellpadding=0 cellspacing=0 border=0 class=container align=center><tr><td align=center class=hund width=600><img src=https://live.staticflickr.com/65535/49563356026_5371a844cd_n.jpg  width=\"40%\" height=\"40%\" width=300 alt=Logo border=0 style=max-width: 300px; display:block; ></td></tr></table></td></tr></table></td></tr></table></td></tr></table></td></tr>");
        body.append("<tr><td width=100% valign=top align=center class=padding-container style=padding-top: 0px!important; padding-bottom: 18px!important; mso-padding-alt: 0px 0px 18px 0px;><table width=600 cellpadding=0 cellspacing=0 border=0 align=center class=wrapper><tr><td>");
        body.append("<table cellpadding=0 cellspacing=0 border=0><tr><td style=border-radius: 3px; border-bottom: 2px solid #d4d4d4; class=card-1 width=100% valign=top align=center><table style=border-radius: 3px; width=600 cellpadding=0 cellspacing=0 border=0 align=center class=wrapper bgcolor=#ffffff><tr><td align=center>");
        //HEADER
        body.append("<table width=600 cellpadding=0 cellspacing=0 border=0 class=container><tr><td align=center class=hund ripplelink width=600><a href=https://www.citipartum.com/><img align=center width=600 style=border-radius: 3px 3px 0px 0px; width: 100%; max-width: 600px!important class=hund src=\"cid:image1\"></a></td></tr>");
       
        //COLUMNA02
        body.append("<td bgcolor=#293646 class=td-padding align=left style=font-family: 'Roboto Mono', monospace; color: #212121!important; font-size: 24px; line-height: 30px; padding-top: 18px; padding-left: 18px!important; padding-right: 18px!important; padding-bottom: 0px!important; mso-line-height-rule: exactly; mso-padding-alt: 18px 18px 0px 13px;><p align=center><img src=\"cid:image2\" width=\"20%\" height=\"20%\" /></p></td></tr><tr>");
        
        body.append("</table></td></tr></table></td></tr>");
        body.append("</tbody></table></td></tr></table></td></tr></tbody></table></td></tr></table></td></tr></table></td></tr>");
        body.append("<!-- SPACER --><!--[if gte mso 9]><table align=center border=0 cellspacing=0 cellpadding=0 width=600><tr><td align=center valign=top width=600 height=18><![endif]--><tr><td height=18px></td></tr><!--[if gte mso 9]></td></tr></table><![endif]--><!-- END SPACER -->");
        body.append("<tr><td width=100% valign=top align=center class=padding-container><table width=600 cellpadding=0 cellspacing=0 border=0 align=center class=wrapper><tr><td width=100% valign=top align=center><table width=600 cellpadding=0 cellspacing=0 border=0 align=center class=wrapper bgcolor=#eeeeee><tr><td align=center><table width=600 cellpadding=0 cellspacing=0 border=0 class=container><tr>");
        //OTRO
        body.append("<td align=center width=300 style=padding-top: 0px!important; padding-bottom: 18px!important; mso-padding-alt: 0px 0px 18px 0px;><table border=0 cellspacing=0 cellpadding=0><tr><td align=left valign=top class=social><a href=https://www.facebook.com/Partumcit/?ref=br_rs><img src=http://paulgoddarddesign.com/emails/images/material-design/fb-icon.png width=\"15%\" alt=Facebook border=0 style=display:block; max-width: 24px></a></a></td>");
        //FACEBOOK
        //body.append("<td width="20></td><td align=center width=300 style=padding-top: 0px!important; padding-bottom: 18px!important; mso-padding-alt: 0px 0px 18px 0px;><table border=0 cellspacing=0 cellpadding=0><tr><td align=center valign=top class=social><a href=https://www.instagram.com/citi.partum/?hl=es-la>Facebook</a></td></tr></td>");
        //INSTAGRAM
        body.append("<td width=20></td><td align=right valign=top class=social><a href=https://www.instagram.com/citi.partum/?hl=es-la><img src=http://paulgoddarddesign.com/emails/images/material-design/instagram-icon.png width=\"15%\" alt=Instagram border=0 style=display:block; ></a></td></tr></table></td>");
        body.append("</tr><tr><td class=td-padding align=center style=font-family: 'Roboto Mono', monospace; color: #212121!important; font-size: 16px; line-height: 24px; padding-top: 0px; padding-left: 0px!important; padding-right: 0px!important; padding-bottom: 0px!important; mso-line-height-rule: exactly; mso-padding-alt: 0px 0px 0px 0px;></td></tr></table></td></tr></table></td></tr></table></td></tr>");
        //body.append("</tr><tr><td class=td-padding align=center style=font-family: 'Roboto Mono', monospace; color: #212121!important; font-size: 16px; line-height: 24px; padding-top: 0px; padding-left: 0px!important; padding-right: 0px!important; padding-bottom: 0px!important; mso-line-height-rule: exactly; mso-padding-alt: 0px 0px 0px 0px;>&copy; 2020 by Grupo Partum</td></tr></table></td></tr></table></td></tr></table></td></tr>");
        body.append("<!-- FOOTER --><!-- SPACER --><!--[if gte mso 9]><table align=center border=0 cellspacing=0 cellpadding=0 width=600><tr><td align=center valign=top width=600 height=36><![endif]--><tr><td height=36px></td></tr><!--[if gte mso 9]></td></tr></table><![endif]--><!-- END SPACER -->");
        body.append("</table><!-- END EMAIL --><div style=display:none; white-space:nowrap; font:15px courier; line-height:0;>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</div></body></html>");
 
 
        // inline images
        Map<String, String> inlineImages = new HashMap<String, String>();
        inlineImages.put("image1", "Partum.jpeg");
        inlineImages.put("image2", "MyQrCodeR.png");
        
 
        try 
        {
            EmbeddedImageEmailUtil.send(host, port, mailFrom, password, mailTo,
            subject, body.toString(), inlineImages);
            System.out.println("Email sent.");
            
            respuesta = "ENVIADO";
            return respuesta;
        } 
        catch (Exception ex) 
        {
        	respuesta = "NO_ENVIADO";
            System.out.println("Could not send email.");
            ex.printStackTrace();
            return respuesta;
        }
    }
}