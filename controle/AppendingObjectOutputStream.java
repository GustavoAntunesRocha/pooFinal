/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package controle;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
/**
 * Descrição de AppendingObjectOutputStream.
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
	    * Descrição do método writeStreamHeader
	    */
	   @Override
	   protected void writeStreamHeader() throws IOException {
	      reset();
	   }
	}
