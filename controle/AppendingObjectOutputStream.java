/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package controle;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
/**
 * Descri��o de AppendingObjectOutputStream.
 *
 */
public class AppendingObjectOutputStream extends ObjectOutputStream {
	   /**
	    * O construtor.
	   */
	   public AppendingObjectOutputStream(OutputStream out) throws IOException {
	      super(out);
	   }
	   
	   /**
	    * Descri��o do m�todo writeStreamHeader
	    */
	   @Override
	   protected void writeStreamHeader() throws IOException {
	      reset();
	   }
	}
