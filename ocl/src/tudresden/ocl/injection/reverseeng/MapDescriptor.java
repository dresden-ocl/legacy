/*
Copyright (C) 2000  Steffen Zschaler

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/

/*
 * MapDescriptor.java
 *
 * Created on 7. August 2000, 17:49
 */
 
package tudresden.ocl.injection.reverseeng;

/** 
  * Descriptor for a class attribute of map type.
  *
  * <p>These descriptors are maintained by {@see AnalysisConsumer} in its m_lcdMaps member.</p>
  *
  * @author  sz9 (Steffen Zschaler)
  * @version 0.1
  */
public class MapDescriptor extends Object {

  /**
    * The name of the attribute.
    */
  private String m_sName;
  
  /**
    * The key type.
    */
  private String m_sKeyType;

  /**
    * The element type.
    */
  private String m_sElementType;
  
  /**
    * The comment number.
    */
  private int m_nCommentID;

  
  /** 
    * Creates new MapDescriptor 
    */
  public MapDescriptor(String sName, String sKeyType, String sElementType, int nCommentID) {
    super ();
    
    m_sName = sName;
    m_sKeyType = sKeyType;
    m_sElementType = sElementType;
    m_nCommentID = nCommentID;
  }
  
    public String getName () {
    return m_sName;
  }
  
  public String getKeyType () {
    return m_sKeyType;
  }
  
  public void setKeyType (String sKeyType) {
    m_sKeyType = sKeyType;
  }
 
  public String getElementType () {
    return m_sElementType;
  }
  
  public void setElementType (String sElementType) {
    m_sElementType = sElementType;
  }
  
  public int getCommentID () {
    return m_nCommentID;
  }
  
  public String toString () {
    return "Map<" + getKeyType () + " -> " + getElementType () + "> " + getName () + " at comment ID " + getCommentID ();
  }
}