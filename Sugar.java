//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Sugar.java
//  @ Date : 18.11.2015
//  @ Author : 
//
//


import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Sugar extends Food
{
    public int sideHalfLength;

    public void draw( Graphics2D g2d )
    {
        g2d.setPaint( Color.red );
//        g2d.draw( new Rectangle2D.Double( (int) this.location.getX(), (int) this.location.getY(), this.sideHalfLength, this.sideHalfLength ) );
        g2d.fill( new Rectangle2D.Double( (int) this.location.getX(), (int) this.location.getY(), this.sideHalfLength, this.sideHalfLength ) );
        g2d.drawString( "akd amk", (int) location.getX(), (int) this.location.getY() );
    }
}
