package com.groot.sloupe.Net.Jsoup.Teste;

import android.widget.EditText;
import android.widget.TextView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Random;

public class JsoupTeste {

    private static final String url = "https://prnt.sc/";
    private final Random random = new Random( );
    private String valueString;
    private int value;
    private String imgUrl;

    public void setValueString( String ValueString ) {
        this.valueString = ValueString;
    }


    public String getValueString() {
        return valueString;
    }

    public void setValue( int Value ) {
        this.value = Value;
    }

    public int getValue() {
        return value;
    }

    public void setImgUrl( String ImgUrl ) {
        this.imgUrl = ImgUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * This Method
     * Automatically Generates
     * The English Alphabet Randomly
     * And
     * return char symbol
     */
    private char getChar() {
        return ( char ) ( random.nextInt( 26 ) + 'a' );
    }

    /**
     * This Method
     * Automatically Generates
     * The Number Randomly
     * And
     * return int
     */

    private String randomInt() {
        int i = random.nextInt( 10 );
        return String.valueOf( i );
    }


    private String getUrlRandom() {
        int value = random.nextInt( 3 );
        String userUrl = getValueString( );
        if ( value == 0 ) {
            return userUrl + getChar( ) + getChar( ) + randomInt( );
        } else if ( value == 1 ) {
            return userUrl + getChar( ) + randomInt( ) + randomInt( );
        }
        return userUrl + getChar( ) + getChar( ) + getChar( );
    }


    public String getUrl() throws IOException {
        setImgUrl( url + getUrlRandom( ) );
        Document document = Jsoup.connect( getImgUrl( ) ).get( );
        Element element1 = document.select( "img" ).first( );
        String res = element1.absUrl( "src" );
        setImgUrl( res );
        System.out.println( res );
//        String af = setImgUrl(res);
        return res;
    }

    public String getUrlArr() throws IOException {
        String valueS = "";
        for ( int i = 0; i < getValue( ); i++ ) {
            setImgUrl( url + getUrlRandom( ) );
            Document document = Jsoup.connect( getImgUrl( ) ).get( );
            Element element1 = document.select( "img" ).first( );
            String res = element1.absUrl( "src" );
            System.out.println( res );
        }
        return valueS;
    }


    public void getUrlArrAndSave() throws IOException {
        String valueS = "";
        for ( int i = 0; i < getValue( ); i++ ) {
            setImgUrl( url + getUrlRandom( ) );
            Document document = Jsoup.connect( getImgUrl( ) ).get( );
            Element element1 = document.select( "img" ).first( );
            String res = element1.absUrl( "src" );
            System.out.println("Image URL : " + i  + " " + res );
            String Compare = res.substring( 0, 14 );
            String CompareTo = "https://i.imgu";
            String Compare1 = res.substring( 0, 10 );
            String CompareTo1 = "https://st";

            if ( Compare1.equalsIgnoreCase( CompareTo1 ) ) {
                System.out.println( "image not found generate new link " );
                System.out.println(  );
                int i1 = random.nextInt( 4 );
                if ( i1==0 ){
                    setValueString("qe2");
                } else if (i1==1 ) {
                    setValueString("ogh");
                }else if ( i1==2 ){
                    setValueString("ulk");
                }else if ( i1==3 ){
                    setValueString("pol");
                }else{
                    setValueString("uhd");
                }
                setImgUrl( getValueString( ) + getUrlRandom( ) );

            } else if ( Compare.equalsIgnoreCase( CompareTo ) ) {
                String name = res;
                name = name.substring( 0, 0 ) + name.substring( 20 );
                String nameFile = "D:\\img\\" + name;
                InputStream in = new URL( res ).openStream( );
                Files.copy( in, Paths.get( nameFile ), StandardCopyOption.REPLACE_EXISTING );
                System.out.println( "Image : " + " " + nameFile + " Save " );

            } else {
                valueS = res;
                valueS = valueS.substring( 0, 0 ) + valueS.substring( 32 );
                String name = "D:\\img\\" + valueS;
                InputStream in = new URL( res ).openStream( );
                Files.copy( in, Paths.get( name ), StandardCopyOption.REPLACE_EXISTING );
                System.out.println( "Image : " + valueS + " Save " );
            }
        }
    }

}
