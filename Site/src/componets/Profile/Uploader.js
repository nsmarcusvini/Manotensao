import { useState } from 'react'
import './Profile.css'
import { MdCloudUpload, MdDelete } from 'react-icons/md'


function Uploader() {

  const [image, setImage] = useState(null)
  const [fileName, setFileName] = useState("No selected file")
  return (
    <main>
      <form
      onClick={() => document.querySelector(".input-field").click()}
      className='formFoto' 
       >
        <input type="file" accept='image/*' className='input-field' hidden 
        onChange={({ target: {files}}) => {
          files[0] && setFileName(files[0].name)
          if(files){
            setImage(URL.createObjectURL(files[0]))
          }
        }}
         />

        {image ?
        <img src={image} width={150} height={150} alt={fileName} />
        : 
        <>
        <MdCloudUpload color='#1475cf' size={60} />
       
        </>
      }

      </form>

      {/* <section className='uploaded-row'>
        <AiFillFileImage color='#1475cf' />
        <span className='upload-content'>
          {fileName} - 
          <MdDelete
          onClick={() => {
            setFileName("No selected File")
            setImage(null)
          }}
           />
        </span>
      </section> */}

    </main>
  )
}

export default Uploader