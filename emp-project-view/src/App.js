import logo from './logo.svg';
import './App.css';
import Navbar from './components/Navbar';

function App() {
  return (
    <>
  <Navbar/>
    <div className="container mx-auto my-8">
    <div>
         <button className="bg-slate-600 hover:bg-blue-700 my-12 font-semibold px-20 py-2 rounded">Add Employee</button>
    </div>
    <div>
      <table className="shadow">
        <thead className='bg-slate-600'>
          <th className="px-6 py-3 uppercase tracking-wide">Name</th>
          <th className="px-6 py-3 uppercase tracking-wide">phone</th>
          <th className="px-6 py-3 uppercase tracking-wide">Email</th>
        </thead>
        <tbody>
          <tr className='hover:bg-white hover:text-black'>
            <td className="text-left px-6 py-4 whitespace-nowrap">Coding Wallah</td>
          <td className="text-left px-6 py-4 whitespace-nowrap">9811111</td>
          <td className="text-left px-6 py-4 whitespace-nowrap">CodingWallah@gmail.com</td>
          <td className="text-left px-6 py-4 whitespace-nowrap">
            <a>Edit📝</a>
            <a>Delete🗑️</a>
          </td>
          </tr>
          <tr className='hover:bg-white hover:text-black'>
          <td className="text-left px-6 py-4 whitespace-nowrap">Coding Wallah</td>
          <td className="text-left px-6 py-4 whitespace-nowrap">9811111</td>
          <td className="text-left px-6 py-4 whitespace-nowrap">CodingWallah@gmail.com</td>
          </tr>
        </tbody>
      </table>
    </div>
    </div>
    </>
  );
}

export default App;
