"use client";  // Mark this file as a Client Component

import { useEffect, useState } from 'react';
import './globals.css';  // Import your global CSS styles

export default function Layout({ children }) {
  // Manage state to track when the client has fully loaded
  const [clientLoaded, setClientLoaded] = useState(false);

  useEffect(() => {
    // Set clientLoaded to true after the component mounts on the client side
    setClientLoaded(true);
  }, []);

  return (
    <html lang="en">
      {/* Ensure consistent class application during SSR and CSR */}
      <body className={clientLoaded ? 'client-loaded' : 'loading'}>
        {children}
      </body>
    </html>
  );
}
