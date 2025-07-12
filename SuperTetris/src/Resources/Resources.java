//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: 
//::                                                                         ::
//::     Antonio Manuel Rodrigues Manso                                      ::
//::                                                                         ::
//::     I N S T I T U T O    P O L I T E C N I C O   D E   T O M A R        ::
//::     Escola Superior de Tecnologia de Tomar                              ::
//::     e-mail: manso@ipt.pt                                                ::
//::     url   : http://orion.ipt.pt/~manso                                  ::
//::                                                                         ::
//::     This software was build with the purpose of investigate and         ::
//::     learning.                                                           ::
//::                                                                         ::
//::                                                               (c)2023   ::
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//////////////////////////////////////////////////////////////////////////////
package Resources;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Created on 30/05/2023, 11:19:18
 *
 * @author IPT - computer
 * @version 1.0
 */
public class Resources {

    public static ImageIcon loadIcon(String fileName) {
        //nomralizar o nome
        if(Character.isAlphabetic(fileName.charAt(0)))
            fileName="/"+fileName;
        //ler o icon
        return new ImageIcon(Resources.class.getResource(fileName));
    }
     /**
     * redimensiona um icone
     *
     * @param icon icone
     * @param width largura
     * @param height altura
     * @return icone redimensionado
     */
    public static ImageIcon resizeIcon(Icon icon, int width, int height) {
        //imagem do icone
        Image img = ((ImageIcon) icon).getImage();
        //redimensionar a imagem
        img = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        //retornar um novo icone
        return new ImageIcon(img);
    }

    /**
     * retorna os bytes de um recursos
     *
     * @param resourceName path para o recurso
     * @return array de byte
     * @throws IOException erros de I/O
     */
    public static byte[] readStream(String resourceName) throws IOException {
        //input stream para o recurso        
        InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(resourceName);
        //alocar um array de bytes
        byte[] respourceData = new byte[in.available()];// numero de bytes na stream
        //ler os dados
        in.read(respourceData);
        //devolver os bytes do recurso
        return respourceData;
    }

    /**
     * retorna os bytes de um recursos usando NIO
     *
     * @param resourceName path para o recurso
     * @return array de byte
     * @throws URISyntaxException erros no nome do recurso
     * @throws IOException erros de I/O
     */
    public static byte[] readBytes(String resourceName) throws URISyntaxException, IOException {
        //path para um recurso
        Path path = Paths.get(ClassLoader.getSystemResource(resourceName).toURI());
        //devolver os bytes do recurso
        return Files.readAllBytes(path);
    }

    /**
     * retorna o objeto que representa a imagem de um recurso
     *
     * @param resourceName path para a imagem
     * @return imagem
     * @throws IOException erros de I/O
     */
    public static Image loadResourceImage(String resourceName) throws IOException {
        //input stream para o recurso        
        InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(resourceName);
        //ler a imagem e retornar o objeto
        return ImageIO.read(in);

    }

    /**
     * Lê um som a partir de um recurso
     *
     * @param resourceName nome do recurso
     * @return objeto que representa o som
     * @throws IOException erros de I/O
     * @throws UnsupportedAudioFileException formato não suportado
     * @throws LineUnavailableException dados corrompidos
     */
    public static Clip loadResourceSound(String resourceName) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        //input stream para o recurso        
        InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(resourceName);
        //input stream para ler som
        AudioInputStream ain = AudioSystem.getAudioInputStream(in);
        //obter o objeto para tocar o som
        Clip clip = AudioSystem.getClip();
        //ler o som 
        clip.open(ain);
        //retorn o som
        return clip;
    }
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 202305301119L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2023  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////
}
