package com.reviewQueue.model;
    public abstract class Enumeration extends Entity
    {
        public Enumeration()
        {
            super();
        }


        protected Enumeration(int id, String name)
        {
            this(id, name, name, true);
        }
        protected Enumeration(int id, String name, String displayName, Boolean showInUI)
        {
            Id = id;
            Name = name;
            DisplayName = displayName;
            ShowInUI = showInUI;
        }

            
        //public  int Id;
        public  Boolean ShowInUI;
        public  String Name;
        public  String DisplayName;

        public String ToString()
        {
            return DisplayName;
        }

//        public static IEnumerable<T> GetAll<T>() where T : Enumeration, new()
//        {
//            var type = typeof(T);
//            var fields = type.GetFields(BindingFlags.Public | BindingFlags.Static | BindingFlags.DeclaredOnly);
//
//            foreach (var info in fields)
//            {
//                var instance = new T();
//                var locatedValue = info.GetValue(instance) as T;
//
//                if (locatedValue != null)
//                {
//                    yield return locatedValue;
//                }
//            }
//        }

        public  Boolean Equals(Enumeration other)
        {

            if (other == null)
            {
                return false;
            }
            return Id == other.Id;
        }






        public static int AbsoluteDifference(Enumeration firstValue, Enumeration secondValue)
        {
            return Math.abs(firstValue.Id - secondValue.Id);
        }

//        public static <T extends Enumeration> T FromValue(int value)
//        {
//            T matchingItem = parse<T, int>(value, "id", item => item.Id == value);
//            return matchingItem;
//        }
//
//        public static <T extends Enumeration> T FromName(String name)
//        {
//            name = name.toLowerCase();
//            var matchingItem = parse<T, String>(name, "name", item => item.Name.ToLower() == name);
//            return matchingItem;
//        }
//
//        private static <T extends Enumeration, K>  T parse(K value, String description, Func<T, bool> predicate) where T : Enumeration, new()
//        {
//            var matchingItem = GetAll<T>().FirstOrDefault(predicate);
//
//            if (matchingItem == null)
//            {
//                var message = String.Format("'{0}' is not a valid {1} in {2}", value, description, typeof(T));
//                throw new ApplicationException(message);
//            }
//
//            return matchingItem;
//        }
//
//        public  int CompareTo(object other)
//        {
//            return Id.CompareTo(((Enumeration)other).Id);
//        }
//    }

}
