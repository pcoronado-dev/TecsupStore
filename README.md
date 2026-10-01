* Este cambio corresponde solamente al COMMIT 1: 
Actúa como desarrollador experto en Kotlin, Jetpack Compose y Material 3.

Tengo una aplicación llamada TECSUP Store que ya tiene:

- AppNavegacion.kt
- AppDrawer.kt
- TarjetaProducto.kt
- NavigationDrawer funcionando.
- DropdownMenu funcionando en cada producto.
- Opciones Favoritos, Compartir y Reportar.

Quiero realizar el PRIMER cambio de una mejora llamada "mejora-ia".

OBJETIVO DEL COMMIT 1:
Implementar el estado de favoritos a nivel de AppNavegacion para poder saber cuántos productos diferentes fueron marcados como favoritos.

REQUISITOS:
1. Crear una lista o conjunto de productos favoritos utilizando remember y mutableStateOf.
2. Cada producto debe identificarse por su nombre o un ID.
3. TarjetaProducto debe recibir un parámetro que permita informar a la pantalla principal cuando el usuario marque un producto como favorito.
4. Al seleccionar "Favoritos" desde el DropdownMenu, el producto debe agregarse al conjunto de favoritos.
5. Si el producto ya está marcado como favorito, no debe agregarse nuevamente.
6. No modificar todavía visualmente el NavigationDrawer.
7. No crear todavía el badge.
8. Mantener el diseño actual de TECSUP Store.
9. Mantener funcionando las opciones Compartir y Reportar.
10. Proporciona el código completo de los archivos que deban modificarse.
11. Explica exactamente qué código debo reemplazar y en qué archivo.
12. No cambies nombres de paquetes innecesariamente.

Al finalizar, indícame qué archivos fueron modificados y cómo comprobar que el contador interno de favoritos funciona.

* Este cambio corresponde solamente al COMMIT 2: 
Continúa trabajando sobre mi aplicación TECSUP Store en Kotlin + Jetpack Compose + Material 3.

En el COMMIT 1 implementé un estado en AppNavegacion para almacenar los productos marcados como favoritos desde el DropdownMenu de cada TarjetaProducto.

Ahora quiero realizar únicamente el COMMIT 2.

OBJETIVO:
Mostrar un badge con contador en el ítem "Favoritos" del NavigationDrawer.

REQUISITOS:
1. El NavigationDrawer está implementado en AppDrawer.kt mediante ModalDrawerSheet y NavigationDrawerItem.
2. El ítem "Favoritos" debe mostrar un badge a la derecha.
3. El badge debe mostrar la cantidad actual de productos favoritos.
4. El contador debe venir directamente del estado de favoritos existente en AppNavegacion.
5. AppDrawer debe recibir el número de favoritos mediante un parámetro, por ejemplo favoritosCount: Int.
6. El badge debe desaparecer o no mostrarse cuando el contador sea 0.
7. Cuando el usuario marque un producto como favorito desde el DropdownMenu, el número debe actualizarse automáticamente.
8. No crear una lista de favoritos independiente dentro de AppDrawer.
9. No duplicar el estado.
10. Mantener el estilo visual morado/lila de mi aplicación.
11. El badge debe estar alineado a la derecha del texto "Favoritos".
12. Mantener funcionando la selección activa del NavigationDrawer.
13. No modificar innecesariamente las otras opciones del Drawer.
14. Proporciona el código completo de AppDrawer.kt y los cambios necesarios en AppNavegacion.kt.
15. Explica exactamente dónde debo colocar cada cambio.

Quiero que el resultado visual sea similar a:

Inicio
Mis pedidos
♡ Favoritos                         3
Perfil
Cerrar sesión

El número debe cambiar dinámicamente según los productos marcados como favoritos.

* Este cambio corresponde solamente al COMMIT 3:
Continúa trabajando sobre mi aplicación TECSUP Store desarrollada con Kotlin, Jetpack Compose y Material 3.

Ya realicé estos cambios:

COMMIT 1:
- Implementé el estado de productos favoritos en AppNavegacion.
- TarjetaProducto puede informar cuando un producto se marca como favorito.

COMMIT 2:
- AppDrawer recibe el contador de favoritos.
- El ítem "Favoritos" muestra un badge con la cantidad.
- El badge se actualiza cuando se agregan favoritos.

Ahora quiero realizar únicamente el COMMIT 3.

OBJETIVO:
Mejorar la integración y experiencia visual de la funcionalidad de favoritos sin cambiar la arquitectura existente.

REQUISITOS:
1. Un producto no debe poder contabilizarse dos veces como favorito.
2. Si el producto ya está en favoritos, seleccionar nuevamente "Favoritos" no debe incrementar el contador.
3. Cambiar visualmente la opción "Favoritos" del DropdownMenu según el estado del producto.
4. Si el producto ya es favorito, mostrar un estado visual como "En favoritos" o equivalente.
5. Mantener el contador del NavigationDrawer sincronizado con el estado real.
6. El badge debe actualizarse inmediatamente mediante recomposición de Compose.
7. Mantener el diseño morado/lila existente.
8. No eliminar DropdownMenu.
9. No eliminar NavigationDrawer.
10. No modificar Compartir ni Reportar.
11. No crear una segunda fuente de datos para favoritos.
12. Mantener la navegación existente.
13. Proporciona el código completo de los archivos que deban modificarse.
14. Explica cómo probar:
   - 0 favoritos
   - 1 favorito
   - 2 favoritos
   - intentar agregar dos veces el mismo producto
   - comprobar que el contador no se duplique.
15. Mantén el código sencillo y apropiado para un estudiante que está aprendiendo Jetpack Compose.

