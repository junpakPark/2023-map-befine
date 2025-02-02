import {
  Dispatch,
  ReactNode,
  SetStateAction,
  createContext,
  useState,
} from 'react';
import ToastProps from '../types/Toast';

interface ToastContextProps {
  toast: ToastProps;
  setToast: Dispatch<SetStateAction<ToastProps>>;
}

interface ToastProviderProps {
  children: ReactNode;
}

export const ToastContext = createContext<ToastContextProps>({
  toast: { show: false, type: 'info', message: '' },
  setToast: () => {},
});

const ToastProvider = ({ children }: ToastProviderProps) => {
  const [toast, setToast] = useState<ToastProps>({
    show: false,
    type: 'info',
    message: '',
  });

  return (
    <ToastContext.Provider
      value={{
        toast,
        setToast,
      }}
    >
      {children}
    </ToastContext.Provider>
  );
};

export default ToastProvider;
