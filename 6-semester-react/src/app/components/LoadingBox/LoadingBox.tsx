import './LoadingBox.scss';

export interface LoadingBoxShape {
  margin?: string;
  width: string;
  height: string;
}

export interface LoadingBoxProperties {
  width: string;
  height: string;
  shapes: LoadingBoxShape[];
}

const LoadingBox = ({ props }: { props: LoadingBoxProperties }) => {

  const transformedShapes = props.shapes.map((shape, index) =>
    <div key={index} className="shape" style={{ margin: shape.margin, width: shape.width, height: shape.height }}></div>
  )

  return <div className='wrapper'>
    <div className='wrapper-cell' style={{ width: props.width, height: props.height }}>
      {transformedShapes}
    </div>
  </div>
}

export default LoadingBox;
