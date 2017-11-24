export const getCurrentAuth = () => {
  if (!localStorage.id || !localStorage.token) {
    return;
  }
  return {
    id : localStorage.id,
    token : localStorage.token
  }
}

export const setCurrentAuth = (auth) => {
  localStorage.id = auth.id;
  localStorage.token = auth.token;
}

var currentUser;

export const getCurrentUser = () => {
  return currentUser;
}

export const setCurrentUser = (user) => {
  return currentUser = user;
}

export const logout = () => {
  localStorage.removeItem("id");
  localStorage.removeItem("token");
}
